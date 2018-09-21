package OnlineTest;

import org.junit.Test;

/**
 * 二分查找法
 * 
 * @author wangyanlong
 *
 */
public class BinarySearch {
	/**
	 * 
	 * @param array
	 * @param key
	 *            要查找的目标值
	 * @return 若找到返回key在数组中的下标，若没找到则返回-1
	 */
	public static int binarySearch(int[] array, int key) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {// 在start<=end条件下，如果不存在key==array[mid]，则表明数组中不含key
			int mid = (start + end) / 2;// 中间折半的下标，每次折半都必须更新一次mid的下标
			if (key > array[mid]) {
				start = mid + 1;
			} else if (key < array[mid]) {
				end = mid - 1;
			} else if (key == array[mid]) {
				return mid;// 返回key的下标
			}
		}

		return -1;// 当数组中不存在key时，返回-1
	}

	/**
	 * 递归实现二分查找法
	 * 
	 * @param array
	 * @param key
	 * @param start
	 * @param end
	 * @return如果key在数组中，则返回其在数组中的下标，若不在数组中，则返回-1
	 */
	public static int binarySearch2(int[] array, int key, int start, int end) {
		if (start > end) {// 如果没找到key退出递归条件
			return -1;
		}
		int mid = (start + end) / 2;
		if (key < array[mid]) {
			return binarySearch2(array, key, start, mid - 1);
		} else if (key > array[mid]) {
			return binarySearch2(array, key, mid + 1, end);
		} else {
			return mid;
		}

	}

	public static int findFirstK(int[] array, int k, int start, int end) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;

		if (k == array[mid]) {
			if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				return findFirstK(array, k, start, mid - 1);
			}
		} else if (k < array[mid]) {
			return findFirstK(array, k, start, mid - 1);
		} else {
			return findFirstK(array, k, mid + 1, end);
		}

	}

	public static int findLastK(int[] array, int k, int start, int end) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (k == array[mid]) {
			if ((mid < end && array[mid + 1] != k) || mid == end) {
				return mid;
			} else {
				return findLastK(array, k, mid + 1, end);
			}
		} else if (k < array[mid]) {
			return findLastK(array, k, start, mid - 1);
		} else {
			return findLastK(array, k, mid + 1, end);
		}

	}

	@Test
	public void demo1() {
		int key = 16;
		int[] array = new int[] { 1, 3, 5, 7, 9, 13, 16 };
		System.out.println(binarySearch(array, key));
		System.out.println(binarySearch2(array, key, 0, array.length - 1));
	}

	@Test
	public void demo2() {
		int k = 4;
		int[] array = new int[] { 4, 4, 4, 4 };
		int start = findFirstK(array, k, 0, array.length - 1);
		int end = findLastK(array, k, 0, array.length - 1);
		if (start == -1 || end == -1) {
			System.out.println("该数组为空或长度为0或不包含k");
		} else {
			System.out.println(start);
			System.out.println(end);
			System.out.println(end - start + 1);
		}

	}
}
