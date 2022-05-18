package ru.asfick.methods;

/**
 * Класс, отвечающий за сортировку выбором
 * @author Asfick
 *
 */
public class SelectionSort implements SortingMethod {
	
	private final static String NAME = "Сортировка выбором";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {

		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		for (int index_a = 0; index_a < array.length; index_a++) {
			int min = index_a;
			
			for (int index_b = index_a; index_b < array.length; index_b++) {
				if (array[index_b] < array[min])
					min = index_b;
			}
			
			SortingMethod.swap(array, min, index_a);
		}
		
		//SortingMethod.writeArray(array);
	}

}
