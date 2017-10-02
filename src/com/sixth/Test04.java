package com.sixth;

import java.util.Scanner;
//Bellman-Ford算法队列优化
//时间复杂度最高为O(NM)
public class Test04 {
	// 设INF为无限大
	final static int INF = 999999999;// 略小于int类型最大值2147483647/2
	// 记录哪些顶点已经在队列中
	static int[] book = new int[101];
	static int n;
	// 记录1号顶点到其他顶点的初始路程
	static int[] dis;

	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		// 输入顶点个数
		n = sc.nextInt();
		int[] first = new int[n + 1];
		// 初始化first数组下标1-n的值为-1
		// 表示1-n顶点暂时都没边
		for (int i = 1; i <= n; i++) {
			first[i] = -1;
		}
		dis = new int[n + 1];

		// 读入顶点之间的边
		int m;// 共m条边
		m = sc.nextInt();
		int[] next = new int[m + 1];
		int[] u = new int[m + 1];
		int[] v = new int[m + 1];
		int[] w = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			// u[i]到v[i]的单向长度为w[i]
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
			// 建立邻接表的关键
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		// 初始化dis数组，这里是1号顶点到其余各个顶点的初始路程
		for (int i = 1; i <= n; i++) {
			dis[i] = INF;
		}
		dis[1] = 0;
		// 定义并初始化一个队列
		int[] que = new int[101];
		int head = 1, tail = 1;

		// 1号顶点入队
		que[tail] = 1;
		tail++;
		book[1] = 1;// 标记1号顶点已经入队
		while (head < tail) {// 队列不为空的时候循环
			k = first[que[head]];// 当前需要处理的队首顶点
			while (k != -1) {
				// 判断是否松弛成功
				if (dis[v[k]] > dis[u[k]] + w[k]) {
					// 更新顶点1到顶点顶点v[k]的路程
					dis[v[k]] = dis[u[k]] + w[k];
					// 0表示不在队列中，将顶点v[k]加入队列中
					if (book[v[k]] == 0) {
						// 入队操作
						que[tail] = v[k];
						tail++;
						book[v[k]] = 1;// 同时标记顶点v[k]已经入队
					}
				}
				k = next[k];
			}
			// 出队
			book[que[head]] = 0;
			head++;
		}
		// 输出结果
		for (int i = 1; i <= n; i++) {
			System.out.print(dis[i] + " ");
		}
	}
}
