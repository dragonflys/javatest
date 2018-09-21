package OnlineTest;

/**
 * 在二维有序数组中查重目标数字
 * @author wangyanlong
 *
 */
public class FindTargetTwoArray {

	public static void main(String[] args) {
		int[][] array = {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		System.out.println(find(15,array));

	}
	
	public static boolean find(int target,int[][] array){
		int row = 0;
		int column = array[0].length - 1;
		while (row < array.length && column >= 0) {
			if (target == array[row][column]) {
				return true;
			}else if (target > array[row][column]) {
				row++;
			}else if (target < array[row][column]) {
				column--;
			}
		}
		return false;
	}

}
