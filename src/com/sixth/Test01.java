package com.sixth;

import java.util.Scanner;
//Floyd-Warshall算法求任意两点最短路径(无负权边)
/*DemoData
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12*/
public class Test01 {
	//设INF为无限大
	final static int INF = 999999999;//略小于int类型最大值2147483647/2
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
					e[i][j] = INF;
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
		//Floyd-Warshall算法核心语句
		//最外层表示 第一次只能通过1号城市中转
		// 第二次只能通过1号城市,2号城市中转，以此类推
		for (int k = 1; k <=n; k++) {
			//表示出发地
			for (int i = 1; i <= n; i++) {
				//表示目的地
				for (int j = 1; j <= n; j++) {
					//如果i到j的路程 > i通过k中转到j大路程
					if (e[i][j] > e[i][k] +e[k][j]) {
						e[i][j] = e[i][k] +e[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(e[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
