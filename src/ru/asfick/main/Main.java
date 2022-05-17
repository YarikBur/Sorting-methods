package ru.asfick.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.asfick.methods.BoubleSorting;
import ru.asfick.methods.SortingMethod;
import ru.asfick.utils.Excel;
import ru.asfick.utils.ExecutionTime;

public class Main {
	private static final int ATTEMPTS = 3;
	
	private static Excel excel;
	
	private static SortingMethod[] methods = {
			new BoubleSorting()
	};
	
	private static int[][] array = {
			new int[10],
			new int[100],
			new int[1000],
			new int[10000]/*,
			new int[100000]*/
	};
	
	public static void main(String[] args) {
		try {
			excel = new Excel("F:\\Desktop\\methods.xls", methods.length * array.length, ATTEMPTS);
			System.out.print("Файл создан и открыт.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (SortingMethod method : methods) {
			excel.createSheet(method.getName());
			System.out.print("Метод \"" + method.getName() + "\" начало сортировки.\n");
			
			for (int array = 0; array < Main.array.length; array++) {
				excel.createLineInfo(Main.array[array].length);
				double time = 0d;
				
				time = ExecutionTime.executionTime(method, ATTEMPTS, Main.array[array], excel);
				
				excel.setAllTime(time);
				
				System.out.print("Метод \"" + method.getName() + "\" (" + Main.array[array].length + " символов) добавлено.\n");
			}
			
			System.out.print("Метод \"" + method.getName() + "\" конец сортировки.\n");
		}
		
		try {
			excel.write();
			excel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Файл закрыт.\n");
	}

}
