package ru.asfick.utils;

import ru.asfick.methods.SortingMethod;

public class ExecutionTime {
	
	private static double getSeconds(long startTime) {
		return (double) ( (System.currentTimeMillis() - startTime) / 1000d );
	}
	
	private static int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	private static void generateArray(int[] array) {
		for (int index = 0; index < array.length; index++) {
			 array[index] = getRandomNumber(0, array.length);
		}
	}
	
	public static double executionTime(SortingMethod method, int attempts, int[] array, Excel excel) {
		long start = System.currentTimeMillis();
		
		for (int index = 0; index < attempts; index++) {
			generateArray(array);
			
			long startTime = System.currentTimeMillis();
			method.sort(array);
			excel.setTime(index, getSeconds(startTime));
		}
		
		return getSeconds(start);
	}
}
