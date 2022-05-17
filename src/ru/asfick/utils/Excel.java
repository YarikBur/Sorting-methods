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

import ru.asfick.methods.SortingMethod;

public class Excel {
	private FileOutputStream fileOutputStream;
	
	private HSSFWorkbook workbook;
	private HSSFSheet[] sheet;
	private HSSFRow row;
	
	private Map<Integer, Info> fileInfo;
	private int sheets;
	private int mapIndex = 1;
	private int rows = 1;
	private int attempts;
	private int colls;
	
	public Excel(String path, int rows, int attempts, int sheets) throws FileNotFoundException {
		fileOutputStream = new FileOutputStream( new File(path) );
		this.workbook = new HSSFWorkbook();
		fileInfo = new TreeMap<Integer, Info>();
		
		this.rows += rows;
		this.attempts = attempts;
		colls = attempts + 2;
		this.sheets = sheets;
	}
	
	public void createSheet(SortingMethod[] methods) {
		
		sheet = new HSSFSheet[methods.length];
		
		for(int index = 0; index < methods.length; index++) {
			sheet[index] = workbook.createSheet(methods[index].getName());
		}
	}
	
	public void createLineInfo(int length) {
		fileInfo.put(mapIndex++, new Info(length, attempts));
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
				cell.setCellValue("Кол-во символов");
			else if ( index == (colls - 1) )
				cell.setCellValue("Суммарное время");
			else
				cell.setCellValue("№" + index);
		}
	}
	
	public void write() throws IOException {
		int index_c = 0;
		for (int index_a = 0; index_a < sheets; index_a++) {
			for (int index_b = 0; index_b < rows; index_b++) {
				row = sheet[index_a].createRow(index_b);
				
				if (index_b == 0) firstRow();
				else {
					Info info = fileInfo.get(index_c);
					
					for (int infoColl = 0; infoColl < colls; infoColl++) {
						
						HSSFCell cell = row.createCell(infoColl);
						
						if (infoColl == 0)
							cell.setCellValue(info.getLength());
						else if ( infoColl == (colls - 1) )
							cell.setCellValue(info.getAllTime());
						else
							cell.setCellValue(info.getTimes()[infoColl-1]);
					}
				}
				if (index_b != rows-1)
					index_c++;
			}
			
			sheet[index_a].autoSizeColumn(0);
			sheet[index_a].autoSizeColumn(colls-1);
		}
		
		workbook.write(fileOutputStream);
	}
	
	public void close() throws IOException {
		workbook.close();
		fileOutputStream.close();
	}
	
	
	
	private class Info {
		private int length;
		private double[] times;
		private double allTime;
		
		public Info(int length, int attempts) {
			setLength(length);
			
			times = new double[attempts];
		}
		
		public int getLength() {
			return length;
		}
		
		public void setLength(int length) {
			this.length = length;
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
