package com.fifth;

import java.util.Arrays;
import java.util.Scanner;
/*
5 8 
1 2 2
1 5 10
2 3 3
2 5 7
3 1 4
3 4 4
4 5 5
5 3 3
*/
//计算图的最短路径
//使用深度优先遍历
public class Test02 {
	static int min = 99999999;
	static int[] book = new int[101]; 
	static int n ;
	static int[][] e  ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入顶点个数
		n = sc.nextInt();
		//初始化二维矩阵
		//0行0列不算。
		e = new int[n+1][n+1];
		for (int i = 1; i < e.length; i++) {
			for (int j = 0; j < e.length; j++) {
				if (i == j) {
					e[i][j] = 0; 
				}else {
					e[i][j] = -1;
				}
			}
		}
		//读入顶点之间的边
		int m;//共m条边
		m = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			//a到b的单向长度为num
			int a = sc.nextInt();
			int b = sc.nextInt();
			int num = sc.nextInt();
			e[a][b] = num;
		}
//		for (int i = 0; i < e.length; i++) {
//			System.out.println(Arrays.toString(e[i]));
//		}
		//从1号城市开始出发，0表示当前已经走过的路程
		book[1] = 1;
		dfs(1,0);
		//打印1号城市到5号城市的最短路径
		System.out.println(min);
	}
	private static void dfs(int cur, int dis) {
		//如果当前走过的路程大于之前找到的最短路，则没有必要再往下尝试了，立即返回
		if (dis>min) {
			return;
		}
		//判断是否到达了目标城市
		if (cur == n) {
			System.out.println("dis:" + dis);
			if (dis < min) {//更新最小值
				min = dis;
				return ;
			}
		}
		//从1号城市到n号城市依次尝试
		for (int i = 1; i < e.length; i++) {
			//看看当前顶点cur到顶点i是否有边相连，且未访问
			if (e[cur][i] > 0 && book[i] == 0) {
				System.out.print(e[cur][i]+" ");
				//把路程加上，并去访问下一个城市
				dfs(i, dis+e[cur][i]);
				book[i] = 1;
				//之前一步探索完之后，取消对城市i的标记
				book[i] = 0;
			}
		}
	}

}
