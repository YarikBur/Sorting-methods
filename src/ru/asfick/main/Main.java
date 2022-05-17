package ru.asfick.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.asfick.methods.BoubleSorting;
import ru.asfick.methods.ShakerSorting;
import ru.asfick.methods.SortingMethod;
import ru.asfick.utils.Excel;
import ru.asfick.utils.ExecutionTime;

public class Main {
	private static final int ATTEMPTS = 3;
	
	private static Excel excel;
	
	private static SortingMethod[] methods = {
			new BoubleSorting(),
			new ShakerSorting()
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
			excel = new Excel("F:\\Desktop\\methods.xls", array.length, ATTEMPTS, methods.length);
			excel.createSheet(methods);
			System.out.print("Файл создан и открыт.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (SortingMethod method : methods) {
			
			System.out.print("\nМетод \"" + method.getName() + "\" начало сортировок.\n");
			
			for (int array = 0; array < Main.array.length; array++) {
				excel.createLineInfo(Main.array[array].length);
				double time = 0d;
				
				time = ExecutionTime.executionTime(method, ATTEMPTS, Main.array[array], excel);
				
				excel.setAllTime(time);
				
				System.out.print("Метод \"" + method.getName() + "\" с " + Main.array[array].length + " символами закончил сортировку.\n");
			}
			
			System.out.print("Метод \"" + method.getName() + "\" конец сортировок.\n\n");
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
