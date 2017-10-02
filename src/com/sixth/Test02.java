package com.sixth;

import java.util.Scanner;
//Dijkstra算法，计算一个顶点到其余各个顶点的最短路径
//以1号到6号为例
/*6 9
1 2 1
1 3 12 
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4*/
public class Test02 {
	//设INF为无限大
		final static int INF = 999999999;//略小于int类型最大值2147483647/2
		//记录1号顶点到哪些顶点的最短路程已经确定
		static int[] book = new int[101]; 
		static int n ;
		static int[][] e ;
		//记录1号顶点到其他顶点的初始路程
		static int[] dis;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入顶点个数
		n = sc.nextInt();
		dis = new int[n+1];
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
		//初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
		for (int i = 1; i <= n; i++) {
			dis[i] = e[1][i];
		}
		//book数组初始化
		for (int i = 1; i <= n; i++) {
			book[i] = 0;
		}
		book[1] = 1;
		//Dijkstra算法核心语句
		int min;
		int u = 0;
		for (int i = 1; i < n; i++) {
			//找到离1号顶点最近的顶点
			min = INF;
			for (int j = 1; j <= n ; j++) {
				if (book[j] == 0 && dis[j]< min) {
					min = dis[j];//记录最小程
					u = j;//记录是哪个顶点
				}
			}
			book[u] = 1;//标记u已经确定了最短路径
			//以目前离s源点最近的u为起点，考察以u为起点的边，对每一条边进行松弛操作	
			for (int v = 1; v <= n ; v++) {
				if (e[u][v]<INF) {
					if (dis[v] > dis[u]+e[u][v]) {
						dis[v] = dis[u]+e[u][v];
					}
				}
			}
		}
		//输出最终结果
		for (int i = 1; i <= n; i++) {
			System.out.println(dis[i]);
		}
	}

}
