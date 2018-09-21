package sort;

import org.junit.Test;

public class Sort {
	/**
	 * 冒泡排序
	 * 
	 * @param array
	 */
	public void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] < array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i : array) {
			System.out.print(i);
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for (int i : array) {
			System.out.print(i);
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] a, int start, int end) {
		if (start >= end) {// 退出递归的条件
			return;
		}
		int i = start;
		int j = end;
		int index = a[i];
		while (i < j) {
			while (i < j && index >= a[j]) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
			}
			while (i < j && index < a[i]) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
			}
			a[i] = index;
		}
		quickSort(a, start, i - 1);
		quickSort(a, i + 1, end);

	}

	/**
	 * 插入排序
	 * 
	 * @param a
	 */
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j = i;
			while (j > 0 && a[j - 1] < temp) {// 从大到小
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
		for (int i : a) {
			System.out.print(i);
		}
	}

	@Test
	public void demo() {

		int[] array = new int[] { 3, 5, 9, 7, 5, 1, 2, 7 };
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i);
		}
		System.out.println();
		insertSort(new int[] { 3, 5, 9, 7, 5, 1, 2, 7 });

		System.out.println();
		bubbleSort(new int[] { 3, 5, 9, 7, 5, 1, 2, 7 });

		System.out.println();
		selectSort(new int[] { 3, 5, 9, 7, 5, 1, 2, 7 });
	}

}
