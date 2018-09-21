package OnlineTest;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class ToMinNum {
	public static String toMinNum(int[] array) {
		if (array == null || array.length == 0) {
			return "";
		}
		String[] str = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			str[i] = String.valueOf(array[i]);
		}
		Arrays.sort(str, new Comparator<String>() {// 按照自定义的大小规则从大到小排序
			@Override
			public int compare(String o1, String o2) {// 制定字符串o1与字符串o2的比较大小规则
				String s1 = o1 + o2;// 按照自定义的比较规则确定o1和o2的大小
				String s2 = o2 + o1;// mn < nm => m < n;
									// mn > nm => m > n;
									// mn = nm => m = n
				return s1.compareTo(s2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();

	}

	@Test
	public void demo() {
		int[] array = new int[] { 3, 54, 43, 215 };
		System.out.println(toMinNum(array));
	}

}
