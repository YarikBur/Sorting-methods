package ru.asfick.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.asfick.methods.BoubleSorting;
import ru.asfick.methods.CombSorting;
import ru.asfick.methods.InsertSorting;
import ru.asfick.methods.SelectionSort;
import ru.asfick.methods.ShakerSorting;
import ru.asfick.methods.SortingMethod;
import ru.asfick.utils.Excel;
import ru.asfick.utils.ExecutionTime;

public class Main {
	/**
	 * Настройка, отвечающая за путь созданного файла с настройками
	 */
	private static String filePath = "F:\\Desktop\\methods.xls";
	
	/**
	 * Настройка, отвечающая за кол-во повторов метода сортировки, каждой длины массива
	 */
	private static int attempts = 3;
	
	/**
	 * Методы сортировки, которые будут учавствовать в проверке
	 */
	private static SortingMethod[] methods = {
			new BoubleSorting(),
			new ShakerSorting(),
			new CombSorting(),
			new InsertSorting(),
			new SelectionSort()
	};
	
	/**
	 * Массивы разной длины, в которых будут генерироваться значения и после сортироваться
	 */
	private static int[][] array = {
			new int[10],
			new int[100],
			new int[1000],
			new int[10000],
			new int[100000]
	};
	
	private static Excel excel;
	
	
	private static void saveArgs(String[] args) {
		filePath = args[0];
		System.out.print("Path: \"" + filePath + "\"\n");
		try {
			attempts = Integer.parseInt(args[1]);
			System.out.print("Attempts: \"" + attempts + "\"\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Standart attempts: " + attempts);
		}
		
	}
	
	private static void createFile() {
		try {
			excel = new Excel(filePath, array.length, attempts, methods.length);
			excel.createSheet(methods);
			
			System.out.print("Файл создан и открыт.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void closeFile() {
		try {
			excel.write();
			excel.close();
			
			System.out.print("Файл закрыт.\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		if (args.length != 0)
			saveArgs(args);
		
		createFile();
		
		for (SortingMethod method : methods) {
			
			System.out.print("\nМетод \"" + method.getName() + "\" начало сортировок.\n");
			
			for (int array = 0; array < Main.array.length; array++) {
				excel.createLineInfo(Main.array[array].length);
				double time = 0d;
				
				System.out.print("Метод \"" + method.getName() + "\" с " + Main.array[array].length + " символами начал сортировку.");
				
				time = ExecutionTime.executionTime(method, attempts, Main.array[array], excel);
				
				excel.setAllTime(time);
				
				System.out.print("\rМетод \"" + method.getName() + "\" с " + Main.array[array].length + " символами закончил сортировку.\n");
			}
			
			System.out.print("Метод \"" + method.getName() + "\" конец сортировок.\n\n");
		}
		
		closeFile();
	}

}
