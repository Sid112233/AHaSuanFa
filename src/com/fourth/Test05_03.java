package com.fourth;

import java.util.Arrays;
//求图中独立子图
public class Test05_03 {
	static int a[][];
	static int book[][] = new int[51][51];
	static int sum;

	static void dfs(int x, int y,int color) {
		int next[][] = { { 0, 1 }, // 向右走
				{ 1, 0 }, // 向下走
				{ 0, -1 }, // 向左走
				{ -1, 0 } };// 向上走
		int tx, ty;
		a[x][y] = color;//对a[x][y]这个格子进行染色
		// 枚举四个方向
		for (int i = 0; i < 4; i++) {
			// 计算下一步坐标
			tx = x + next[i][0];
			ty = y + next[i][1];
			// 判断是否越界
			if (tx < 0 || tx > a.length-1 || ty < 0 || ty > a[0].length-1) {
				continue;
			}
			// 判断是否是陆地
			if (a[tx][ty] > 0 && book[tx][ty] == 0) {
				book[tx][ty] = 1;
				sum++;
				dfs(tx, ty, color);// 尝试下一个点
			}
		}
		return;
	}

	public static void main(String[] args) {
		a = new int[][]{
			{1,2,1,0,0,0,0,0,2,3},
			{3,0,2,0,1,2,1,0,1,2},
			{4,0,1,0,1,2,3,2,0,1},
			{3,2,0,0,0,1,2,4,0,0},
			{0,0,0,0,0,0,1,5,3,0},
			
			{0,1,2,1,0,1,5,4,3,0},
			{0,1,2,3,1,3,6,2,1,0},
			{0,0,3,4,8,9,7,5,0,0},
			{0,0,0,3,7,8,6,0,1,2},
			{0,0,0,0,0,0,0,0,1,0}
		};
		int num = 0;//染色的颜色编号
		//对每个大于0的点尝试dfs染色
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j]>0) {
//					每个岛染不同的颜色,因此每次-1
					num--;
					book[i][j] = 1;
					dfs(i, j, num);
				}
			}
		}
		//输出染色后的地图
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		//输出小岛个数
		System.out.println("小岛共有:"+(-num)+"个");
	}
}
