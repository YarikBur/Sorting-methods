package ru.asfick.utils;

import ru.asfick.methods.SortingMethod;

public class ExecutionTime {
	
	private static double getSeconds(long startTime) {
		return (double) ( (System.currentTimeMillis() - startTime) / 1000 );
	}
	
	public static double executionTime(SortingMethod method, int attempts, int[] array, Excel excel) {
		long start = System.currentTimeMillis();
		
		for (int index = 0; index < attempts; index++) {
			long startTime = System.currentTimeMillis();
			method.sort(array);
			excel.setTime(index, getSeconds(startTime));
		}
		
		return getSeconds(start);
	}
}
