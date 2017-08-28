package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//广度优先遍历图(邻接矩阵)
public class Test01_B {
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			//因为是无向图，所以双向都要设为1
			e[a][b] = 1;
			e[b][a] = 1;
		}
		
		System.out.println("广度优先搜索遍历：");
		method();
	}
	private static void method() {
		//1号顶点开始遍历
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		book[1] = 1;
		//容器为空说明访问完了
		while (!arrayList.isEmpty()) {
			//当前访问的顶点
			int first = arrayList.get(0);
			System.out.print(first+" ");
			arrayList.remove(0);
			//遍历所有顶点，看看当前顶点cur到顶点i是否有边相连
			for (int i = 1; i < e.length; i++) {
				if (e[first][i] == 1 && book[i] == 0) {
					arrayList.add(i);
					book[i] = 1;
				}
			}
		}
	}

}
