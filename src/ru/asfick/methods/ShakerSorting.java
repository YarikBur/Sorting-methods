package ru.asfick.methods;

public class ShakerSorting implements SortingMethod {
	
	private final static String NAME = "Шейкерная сортировка";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {
		
		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		int left = 0;
		int right = array.length - 1;
		int tmp = 0;
		
		while(left <= right) {
			for (int index = right; index > left; index--) {
				if (array[index - 1] > array[index]) {
					tmp = array[index];
					array[index] = array[index - 1];
					array[index - 1] = tmp;
				}
			}
			left++;
			
			for (int index = left; index < right; index++) {
				if (array[index + 1] < array[index]) {
					tmp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = tmp;
				}
			}
			right--;
		}
		
		//SortingMethod.writeArray(array);
	}

}
