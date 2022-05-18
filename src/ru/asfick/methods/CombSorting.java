package ru.asfick.methods;

/**
 * Класс, отвечающий за сортировку расчёской
 * @author Asfick
 *
 */
public class CombSorting implements SortingMethod {
	
	private final static String NAME = "Сортировка расчёской";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {

		//System.out.print('\n');
		//SortingMethod.writeArray(array);
		
		double factor = 1.247d;
		double step = array.length - 1;

		while (step >= 1) {
			for (int index = 0; index + step < array.length; index++) {
				if (array[index] > array[(int) (index + step)])
					SortingMethod.swap( array, index, (int) (index + step) );
			}
			
			step /= factor;
		}
		
		//SortingMethod.writeArray(array);
		
		new BoubleSorting().sort(array);
		
		//SortingMethod.writeArray(array);
	}

}
