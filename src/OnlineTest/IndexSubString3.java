package OnlineTest;
/**
 * 利用String类的indexOf方法查找子字符串
 * @author wangyanlong
 *
 */
public class IndexSubString3 {
	public static void main(String[] args) {
		String s = "acbdcbhhucbgkwje";
		int index = -1;
		int count = 0;
		while (s.indexOf("hh",index + 1) != -1) {
			index = s.indexOf("hh", index + 1);
			count++;
		}
		System.out.println(count);
	}
}
