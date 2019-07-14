package edu.xidian.OnlineTest;
/**
 * 暴力查找子字符串算法
 * @author wangyanlong
 *
 */
public class IndexSubString {
	public static boolean indexString(String superString,String subString){
		int supNum = superString.length();
		int subNum = subString.length();
		int j;
		for (int i = 0; i < supNum - subNum + 1; i++) {
			for (j = 0; j < subNum; j++) {
				if (superString.charAt(i + j) != subString.charAt(j)) {
					break;
				}
			}
			if (j == subNum) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(indexString("abuhgj", "buhg"));
	}
}
