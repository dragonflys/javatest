package OnlineTest;
/**
 * 暴力查找子字符串算法2
 * @author wangyanlong
 *
 */
public class IndexSubString2 {
	public static boolean indexSubString(String supString,String subString){
		char[] supChar = supString.toCharArray();
		char[] subChar = subString.toCharArray();
		int j ;
		for (int i = 0; i < supChar.length - subChar.length + 1; i++) {
			for (j= 0; j < subChar.length; j++) {
				if (supChar[i + j] != subChar[j]) {
					break;
				}
			}
			if (j == subChar.length) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(indexSubString("abcdefg", "defa"));
	}
}
