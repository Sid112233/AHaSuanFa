package com.sixth;

import java.util.Scanner;
//Bellman-Ford算法优化，计算一个顶点到其余各个顶点的最短路径
//解决负权边
//时间复杂度最高为O(NM)
/*
5 5
2 3 2
1 2 -3
1 5 5
4 5 2
3 4 3
*/
public class Test03_2 {
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
		int[] bak = new int [n+1];//备份dis的数组
		
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
		int check ;
		for (int k = 1; k <= n-1; k++) {
			//将dis数组备份到bak数组中
			for (int i = 1; i <= n; i++) {
				bak[i] = dis[i];
			}
			//进行一轮松弛
			for (int i = 1; i <= m; i++) {
				if (dis[v[i]] > dis[u[i]] + w[i]) {
					dis[v[i]] = dis[u[i]] + w[i];
				}
			}
			check = 0;
			//松弛完毕后检测dis数组是否有更新
			for (int i = 1; i < n; i++) {
				if (bak[i] != dis[i]) {
					check = 1;
					break;
				}
			}
			//如果dis数组没有更新，提前结束循环结束算法
			if (check == 0) {
				break;
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
