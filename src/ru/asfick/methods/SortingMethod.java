package ru.asfick.methods;

public interface SortingMethod {
	public String getName();
	public void sort(int[] array);
	
	public static void writeArray(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.print('\n');
	}
}
