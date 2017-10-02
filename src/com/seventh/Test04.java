package com.seventh;

import java.util.Scanner;

/*并查集-
10 9
1 2   3 4   5 2   4 6  2 6
8 7   9 7   1 6   2 4 
*/
public class Test04 {
	static int[] f = new int[1000];
	static int n,m,k,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//强盗人数
		m = sc.nextInt();//警方搜集到的线索条数
		
		//初始化
		init();
		int x,y;
		for (int i = 1; i <= m; i++) {
			//开始合并犯罪团伙
			x = sc.nextInt();
			y = sc.nextInt();
			merge(x,y);
		}
		
		//最后扫描有多少个独立的犯罪团伙
		for (int i = 1; i <= n; i++) {
			if (f[i] == i) {
				sum++;
			}
		}
		System.out.println("共有"+sum+"个独立犯罪集团");
		
		
	}
	//这是合并两个子集合的函数
	private static void merge(int v, int u) {
		int t1,t2;
		t1 = getf(v);
		t2 = getf(u);
		//判断两个节点是否在同一个集合中。即是否为同一个祖先。
		if (t1!=t2) {
			f[t2] = t1;
			//“靠左原则”，左边变成右边的BOSS。即把右边的集合，作为左边集合的子集合。
			//经过路径压缩之后，将f[u]的根的值也赋值为v的祖先f[t1].
			
		}
	}
	//这是找爹的递归函数，不停地去找爹，直到找到祖宗为止，其实就是去找
	//犯罪团伙的最高领导人。
	private static int getf(int v) {
		if (f[v] == v) {
			return v;
		}else {
			//这里是路径压缩，每次在函数返回的时候，顺带把路上遇到的人的“BOSS”改为最后找到
			//的祖宗编号，也就是犯罪团伙的最高领导人编号。这样可以提高今后找到犯罪团伙的
			//最高领导人(也就是树的祖先)的速度
			f[v] = getf(f[v]);
			return f[v];
		}
	}
	//初始化
	private static void init() {
		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}
	}

}
