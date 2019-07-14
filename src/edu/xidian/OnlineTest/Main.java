package edu.xidian.OnlineTest;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = 0;
			int l = sc.nextInt();
			int r = sc.nextInt();
			for (int i = l; i <= r; i++) {
				StringBuffer s1 = new StringBuffer(String.valueOf(i));
				StringBuffer s2 = new StringBuffer(s1);
				StringBuffer s3 = s1.reverse();
				if (s3.toString().equals(s2.toString()) == false) {
					continue;
				}else {
					int m = 2;
					for (int j = 2; j < i; j++) {
						if (i % j == 0) {
							break;
						}else {
							m++;
						}
					}
					if (m == i) {
						n++;
					}
				}
			}
	
			System.out.println(n);
			
		}
	}

}
