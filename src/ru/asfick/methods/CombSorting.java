package ru.asfick.methods;

public class CombSorting implements SortingMethod {
	
	private final static String NAME = "Сортировка расчёской";
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void sort(int[] array) {

		System.out.print('\n');
		SortingMethod.writeArray(array);
		
		double factor = 1.247d;
		double step = array.length - 1;
		int tmp = 0;

		while (step >= 1) {
			for (int index = 0; index + step < array.length; index++) {
				if (array[index] > array[(int) (index + step)]) {
					tmp = array[index];
					array[index] = array[(int) (index + step)];
					array[(int) (index + step)] = tmp;
				}
			}
			
			step /= factor;
		}
		
		SortingMethod.writeArray(array);
		
		new BoubleSorting().sort(array);
		
		SortingMethod.writeArray(array);
	}

}
