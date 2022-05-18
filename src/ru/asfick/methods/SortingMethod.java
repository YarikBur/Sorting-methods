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
	
	public static void swap(int[] array, int index_a, int index_b) {
		int tmp = array[index_a];
		array[index_a] = array[index_b];
		array[index_b] = tmp;
	}
}
