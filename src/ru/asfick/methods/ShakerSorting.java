package ru.asfick.methods;

/**
 * Класс, отвечающий за шейкерную сортировку
 * @author Asfick
 *
 */
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
		
		while(left <= right) {
			for (int index = right; index > left; index--) {
				if (array[index - 1] > array[index]) 
					SortingMethod.swap( array, index, index - 1 );
			}
			left++;
			
			for (int index = left; index < right; index++) {
				if (array[index + 1] < array[index])
					SortingMethod.swap( array, index, index + 1 );
			}
			right--;
		}
		
		//SortingMethod.writeArray(array);
	}

}
