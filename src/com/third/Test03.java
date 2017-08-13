package com.third;
//火柴棍等式， 不超过24根火柴棍，组成a+b=c
public class Test03 {
	public static int fun(int x) {
		int count = 0;
		int[] arr = {6,2,5,5,4,5,6,3,7,6};//记录0-9分别对应的火柴棍根数
		while (x/10 != 0){
			count += arr[x%10];//取个位数，计算火柴棍根数
			x /= 10;//去掉末尾一个数
		} 
		count += arr[x];
		return count;
	}
	public static void main(String[] args) {
		int a,b,c,m,i,sum=0;
		m = 24;//输入火柴棍根数
		for (a = 0; a <= 1111; a++) {
			for (b = 0; b <= 1111; b++) {
				c = a + b;
				if(fun(a) + fun(b) +fun(c) == m-4){//火柴棍之和等于m-4
					System.out.println(a + "+" + b + "=" + c);
					sum++;
				}
			}
		}
		System.out.println("一共可以找出"+sum+"种不同的等式");
	}

}
