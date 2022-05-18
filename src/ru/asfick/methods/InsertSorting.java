package ru.asfick.methods;

/**
 * Класс, отвечающий за сортировку вставками
 * @author Asfick
 *
 */
public class InsertSorting implements SortingMethod {
	
	private final static String NAME = "Сортировка вставками";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {
		
		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		for (int index_a = 1; index_a < array.length; index_a++) {
			int x = array[index_a];
			int index_b = index_a;
			
			while (index_b > 0 && array[index_b - 1] > x) {
				array[index_b] = array[index_b - 1];
				index_b--;
			}
			
			array[index_b] = x;
		}
		
		//SortingMethod.writeArray(array);
	}

}
