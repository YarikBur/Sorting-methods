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
	private static final String FILE_PATH = "F:\\Desktop\\methods.xls";
	
	/**
	 * Настройка, отвечающая за кол-во повторов метода сортировки, каждой длины массива
	 */
	private static final int ATTEMPTS = 3;
	
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
	
	
	public static void main(String[] args) {
		try {
			excel = new Excel(FILE_PATH, array.length, ATTEMPTS, methods.length);
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
				
				System.out.print("Метод \"" + method.getName() + "\" с " + Main.array[array].length + " символами начал сортировку.");
				
				time = ExecutionTime.executionTime(method, ATTEMPTS, Main.array[array], excel);
				
				excel.setAllTime(time);
				
				System.out.print("\rМетод \"" + method.getName() + "\" с " + Main.array[array].length + " символами закончил сортировку.\n");
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
