package ru.asfick.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.asfick.methods.*;
import ru.asfick.utils.*;

public class Main {
	private static final int ATTEMPTS = 10;
	
	private static Excel excel;
	
	private static SortingMethod[] methods = {
			new BoubleSorting()
	};
	
	private static int[][] array = {
			new int[10],
			new int[100],
			new int[1000],
			new int[10000],
			new int[100000]
	};
	
	public static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	private static void generateArray() {
		for (int array = 0; array < Main.array.length; array++) {
			for (int index = 0; index < Main.array[array].length; index++) {
				 Main.array[array][index] = getRandomNumber(0, Main.array[array].length);
			}
		}
	}
	
	public static void main(String[] args) {
		generateArray();
		
		try {
			excel = new Excel("F:\\Desktop\\method.xls", methods.length, ATTEMPTS);
			excel.createSheet("Test");
			System.out.print("Файл создан и открыт.\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (SortingMethod method : methods) {
			excel.createLineInfo(method.getName());
			
			for (int array = 0; array < Main.array.length; array++) {
				double time = 0d;
				
				time = ExecutionTime.executionTime(method, ATTEMPTS, Main.array[array], excel);
				
				excel.setAllTime(time);
			}
			System.out.print("Метод " + method.getName() + " добавлен в таблицу.\n");
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
