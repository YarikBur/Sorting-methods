package ru.asfick.methods;

/**
 * Класс, отвечающий за быструю сортировку
 * @author Yaroslav
 *
 */

public class FastSorting implements SortingMethod {

	private static final String NAME = "Быстрая сортировка";
	
	@Override
	public String getName() {
		return NAME;
	}
	
	private int partition(int[] array, int l, int r) {
		int x = array[r];
		int less = l;
		
		for (int i = l; i < r; i++) {
			if (array[i] <= x) {
				SortingMethod.swap(array, i, less);
				less++;
			}
		}
		
		SortingMethod.swap(array, less, r);
		
		return less;
	}
	
	private void impl(int[] array, int l, int r) {
		if (l < r) {
			int q = partition(array, l, r);
			impl(array, l, q - 1);
			impl(array, q + 1, r);
		}
	}
	
	@Override
	public void sort(int[] array) {
		
		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		impl(array, 0, array.length - 1);
		
		//SortingMethod.writeArray(array);
	}

}
