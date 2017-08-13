package com.third;

public class Test04 {
	//暴力进行全排列
	public static void main(String[] args) {
		for (int a = 1; a <= 3; a++) {
			for (int b = 1; b <= 3; b++) {
				for (int c = 1; c <= 3; c++) {
					if (a!=b && b!=c && a!=c) {
						System.out.println(a+" "+b+" "+c);
					}
				}
			}
		}

	}

}
