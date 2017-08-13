package com.fourth;

import java.util.Scanner;
//深度优先搜索，输出N个数字的全排列
public class Test01 {
	static int[] a = new int[10];
	static int[] book = new int[10];
	static int n;
	static void dfs(int step){//step表示在第几个盒子前
		int i;
		if(step == n+1){//如果站在n+1个盒子前，代表前面n个盒子已经放好扑克
			//输出一种全排列
			for (i = 1; i <= n; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;//返回之前的一步
		}
		
		//此时站在第step个盒子面前,应该放哪张牌？
		//按照1、2、3..n的顺序尝试
		for (i = 1; i <= n; i++) {
			//判断扑克牌是否还在手上
			if (book[i] == 0) {//表示i号扑克牌还在手上
				//开始尝试使用扑克牌i
				a[step] = i;//将i号扑克牌放到第step个盒子中
				book[i] = 1;//表示i号扑克牌已经不再手上
				
				//第step个盒子已经放好扑克牌，接下来需要到step个盒子面前
				dfs(step+1);
				book[i] = 0;//！重要，回收扑克
				
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//输入1-9的整数
		dfs(1);

	}

}
