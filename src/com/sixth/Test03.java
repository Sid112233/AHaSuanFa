package com.sixth;

import java.util.Scanner;
//Bellman-Ford算法，计算一个顶点到其余各个顶点的最短路径
//解决负权边
//时间复杂度O(NM)
/*
5 5
2 3 2
1 2 -3
1 5 5
4 5 2
3 4 3
*/
public class Test03 {
//	INF为无限大
	final static int INF = 999999999;//略小于int类型最大值2147483647/2
	static int n ;//顶点个数
	//记录1号顶点到其他顶点的初始路程
	static int[] dis;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入顶点个数
		n = sc.nextInt();
		dis = new int[n+1];
		
		//读入顶点之间的边
		int m;//共m条边
		m = sc.nextInt();
		int[] u = new int[m+1];
		int[] v = new int[m+1];
		int[] w = new int[m+1];
		for (int i = 1; i <= m; i++) {
			//u[i]到v[i]的单向长度为w[i]
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		//初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
		for (int i = 1; i <= n; i++) {
			dis[i] = INF;
		}
		dis[1] = 0;
		//Bellman-Ford算法核心语句
		//进行n-1轮松弛
		for (int k = 1; k <= n-1; k++) {
			for (int i = 1; i <= m; i++) {
				if (dis[v[i]] > dis[u[i]] + w[i]) {
					dis[v[i]] = dis[u[i]] + w[i];
				}
			}
		}
		//检测负权回路
		//原理：如果此图含有负权回路，那么在n-1轮松弛之后 进行的松弛，还会使最短路出现变化
		int flag = 0;
		for (int i = 1; i <= m; i++) {
			if (dis[v[i]] > dis[u[i]] + w[i]) {
				flag = 1;
			}
		}
		if (flag == 1) {
			System.out.println("此图含有负权回路");
		}else {
			System.out.println("此图不含负权回路");
		}
		//输出结果
		for (int i = 1; i <= n; i++) {
			System.out.print(dis[i]+" ");
		}
	}

}
