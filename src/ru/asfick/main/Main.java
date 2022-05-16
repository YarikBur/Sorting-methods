package ru.asfick.main;

import ru.asfick.methods.*;
import ru.asfick.utils.*;

public class Main {
	
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
		
		for (SortingMethod method : methods) {
			for (int array = 0; array < Main.array.length; array++) {
				double time = 0d;
				int attempts = 10;
				
				time = ExecutionTime.executionTime(method, attempts, Main.array[array]);
				
			}
		}
	}

}
