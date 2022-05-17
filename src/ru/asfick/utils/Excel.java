package ru.asfick.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	private FileOutputStream fileOutputStream;
	
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	
	private Map<Integer, Info> fileInfo;
	private int mapIndex = 1;
	private int rows = 1;
	private int attempts;
	private int colls;
	
	public Excel(String path, int rows, int attempts) throws FileNotFoundException {
		fileOutputStream = new FileOutputStream( new File(path) );
		this.workbook = new HSSFWorkbook();
		fileInfo = new TreeMap<Integer, Info>();
		
		this.rows += rows;
		this.attempts = attempts;
		colls = attempts + 2;
	}
	
	public void createSheet(String sheetName) {
		sheet = workbook.createSheet(sheetName);
	}
	
	public void createLineInfo(String methodName) {
		fileInfo.put(mapIndex++, new Info(methodName, attempts));
	}
	
	public void setTime(int index, double time) {
		fileInfo.get(mapIndex-1).setTime(index, time);
	}
	
	public void setAllTime(double allTime) {
		fileInfo.get(mapIndex-1).setAllTime(allTime);
	}
	
	private void firstRow() {
		for (int index = 0; index < colls; index++) {
			HSSFCell cell = row.createCell(index);
			
			if (index == 0)
				cell.setCellValue("Название сортировки");
			else if ( index == (colls - 1) )
				cell.setCellValue("Суммарное время");
			else
				cell.setCellValue("Попытку №" + index);
		}
	}
	
	public void write() throws IOException {
		for (int index = 0; index < rows; index++) {
			row = sheet.createRow(index);
			
			if (index == 0) firstRow();
			else {
				Info info = fileInfo.get(index);
				
				for (int infoColl = 0; infoColl < colls; infoColl++) {
					
					HSSFCell cell = row.createCell(infoColl);
					
					if (infoColl == 0)
						cell.setCellValue(info.getMethodName());
					else if ( infoColl == (colls - 1) )
						cell.setCellValue(info.getAllTime());
					else
						cell.setCellValue(info.getTimes()[infoColl-1]);
				}
			}
		}
		
		workbook.write(fileOutputStream);
		sheet.autoSizeColumn(1);
	}
	
	public void close() throws IOException {
		workbook.close();
		fileOutputStream.close();
	}
	
	
	private class Info {
		private String methodName;
		private double[] times;
		private double allTime;
		
		public Info(String lineName, int attempts) {
			getMethodName(lineName);
			
			times = new double[attempts];
		}
		
		public String getMethodName() {
			return methodName;
		}
		
		public void getMethodName(String methodName) {
			this.methodName = methodName;
		}
		
		public void setTime(int index, double time) {
			times[index] = time;
		}
		
		public double[] getTimes() {
			return this.times;
		}
		
		public void setAllTime(double allTime) {
			this.allTime = allTime;
		}
		
		public double getAllTime() {
			return this.allTime;
		}
	}
}