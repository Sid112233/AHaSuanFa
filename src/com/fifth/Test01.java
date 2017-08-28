package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//
/*测试数据
5 5
1 2
1 3 
1 5
2 4 
3 5
*/
//深度优先遍历图(邻接矩阵)
public class Test01 {
	static int[] book = new int[101];
	static int sum , n ;
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
		
		System.out.println("深度优先搜索遍历：");
		//从1号城市出发
		book[1]=1;
		//1号顶点开始遍历
		dfs(1);
	}
	//深度优先搜索遍历
	private static void dfs(int cur) {
		//cur代表目前在几号
		System.out.print(cur+" ");
		//每访问一个顶点，sum+1
		sum++;
		if (sum == n) {
			return;//访问过了所有顶点就退出
		}
		//遍历所有顶点，看看当前顶点cur到顶点i是否有边相连
		for (int i = 1; i < e.length; i++) {
			//是否有边，是否已经访问过
			if ( book[i] == 0
					&& e[cur][i] == 1) {
				book[i] = 1;
				dfs(i);
			}
		}
		return;
	}
}
