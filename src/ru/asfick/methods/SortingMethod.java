package ru.asfick.methods;

/**
 * Интерфейс, созданный для упращения переборов типов сортировки
 * @author Yaroslav
 *
 */
public interface SortingMethod {
	/**
	 * Возвращает название метода сортировки
	 * @return - String
	 */
	public String getName();
	
	/**
	 * Метод, отвечающий за сортировку массива
	 * @param array - Массив, который нужно отсортировать
	 */
	public void sort(int[] array);
	
	/**
	 * Выводит массив в консоль
	 * @param array - Массив, который нужно вывести на экран
	 */
	public static void writeArray(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.print('\n');
	}
	
	
	/**
	 * Метод, отвечающий за замену значений в массиве
	 * @param array - Массив, в котором будет произваодиться замена значений
	 * @param index_a - Индекс первого числа для замены
	 * @param index_b - Индекс второго числа для замены
	 */
	public static void swap(int[] array, int index_a, int index_b) {
		int tmp = array[index_a];
		array[index_a] = array[index_b];
		array[index_b] = tmp;
	}
}
