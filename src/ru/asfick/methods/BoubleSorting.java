package ru.asfick.methods;

public class BoubleSorting implements SortingMethod {
	
	private final static String NAME = "Сортировка пузырьком";
	
	@Override
	public String getName() {
		return NAME;
	}
	
	@Override
	public void sort(int[] array) {
		
		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		int tmp = 0;
		
		for (int index_a = 0; index_a < array.length; index_a++) {
			for (int index_b = 0; index_b < array.length - 1; index_b++) {
				if (array[index_b] > array[index_b+1]) {
					tmp = array[index_b];
					array[index_b] = array[index_b+1];
					array[index_b+1] = tmp;
				}
			}
		}
		
		//SortingMethod.writeArray(array);
	}
	
}
