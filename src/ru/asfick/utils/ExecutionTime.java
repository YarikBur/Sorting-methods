package ru.asfick.utils;

import ru.asfick.methods.SortingMethod;

public class ExecutionTime {
	
	private static double getSeconds(long startTime) {
		return (double) ( (System.currentTimeMillis() - startTime) / 1000 );
	}
	
	public static double executionTime(SortingMethod method, int attempts, int[] array) {
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < attempts; i++) {
			method.sort(array);
		}
		
		return (double) ( (System.currentTimeMillis() - start) / 1000 );
	}
}
