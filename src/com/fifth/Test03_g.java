package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//计算最小转机次数，使用广度优先搜索
/*5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5
*/
public class Test03_g {
	static int[] book = new int[101];
	static int sum , n ;
	static int[][] e  ;
	public static void main(String[] args) {
		//所有的初始化操作
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
		//城市之间的航班
		int m;//共m个航班
		m = sc.nextInt();
//		起始城市
		int start = sc.nextInt();
		int end = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			//因为是无向图，所以双向都要设为1
			e[a][b] = 1;
			e[b][a] = 1;
		}
		
		ArrayList<Note> list = new ArrayList<>();
		//从start城市出发，0为转机次数
		
		list.add(new Note(start,0));
		book[start] = 1;
		int cur;
		while (!list.isEmpty()) {
			//当前队首城市(最新加入)编号
			int lastIndex = list.size()-1;
			cur = list.get(lastIndex).x;
//			System.out.println("cur:"+cur);
			for (int i = 1; i < e.length; i++) {
				//判断是否有航线，以及是否到达过这个城市
				if (e[cur][i] == 1 && book[i] == 0) {
					book[i] = 1;
//					System.out.println(list.get(lastIndex).s+1);
					list.add(new Note(i, list.get(lastIndex).s+1));
				}
			}
			if (list.get(list.size()-1).x == end) {
		
				break;
			}
		}
		System.out.println("最少转机次数"+list.get(list.size()-1).s);
	}
}
class Note {
	int x;//城市编号
	int s;//转机次数
	public Note(int x, int s) {
		super();
		this.x = x;
		this.s = s;
	}
}
