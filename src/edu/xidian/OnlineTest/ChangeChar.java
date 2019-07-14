package edu.xidian.OnlineTest;
/**
 * 把字符串中的空格字符全部更换为"%20"
 * @author wangyanlong
 *
 */
public class ChangeChar {
	public static void change(String s){
		char[] a = s.toCharArray();
		int blankNum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ' ') {
				blankNum++;
			}
		}
		char[] b = new char[a.length + 2 * blankNum];
		for (int i = 0,j = i; i < a.length; i++,j++) {
			if (a[i] == ' ') {
				b[j] = '%';
				b[j + 1] = '2';
				b[j + 2] = '0';
				j = j + 2;
			}else {
				b[j] = a[i];
			}
		}
		System.out.println(b);
		
	}
	public static void main(String[] args) {
		String s = "We are champions! ";
		change(s);
	}
}
