package com.fourth;


public class Test02 {
	static int m,n;//列，行
	static int p,q;//终点
	static int min=9999999;
	static int a[][];//标记是否为障碍物
	static int book[][] = new int[51][51];//标记是否走过
	static void dfs(int x,int y,int step){
		int next[][] = {{0,1},//向右走
							{1,0},//向下走
							  {0,-1},//向左走
							 	{-1,0}};//向上走
		int tx,ty;
		//判断是否到达了小哈的位置
		if(x == p && y == q){
			//更新最小值
			if (step < min) {
				min = step;
			}
			return;
		}	
		//走下一步
		for (int k = 0; k <= 3; k++) {
			//计算下一个点的坐标
			tx = x + next[k][0];
			ty = y + next[k][1];
			//判断是否超越了边界
			if (tx<1 || tx>n || ty <1 || ty>m) {
				continue;
			}
			//判断该点是否为障碍物或已经在路径中
			if (a[tx][ty]==0 && book[tx][ty] == 0) {
				book[tx][ty] = 1;//标记这个点已经走过
				dfs(tx, ty, step+1);//开始尝试下一个点
				book[tx][ty] = 0;//尝试结束，取消此点标记
			}
		}
		return;
	}
	public static void main(String[] args) {
		m = 4;//列
		n = 5;//行
		//读入迷宫
		a = new int[][]{{1,1,1,1,1},//第0行第0列表示地图外
						{1,0,0,1,0},
						{1,0,0,0,0},
						{1,0,0,1,0},
						{1,0,1,0,0},
						{1,0,0,0,1}}; 
		//读入起点
		int startx = 1;
		int starty = 1;
		//读入终点
		p = 4;
		q = 3;
		book[startx][starty] = 1;//标记起点已经在路径中
		dfs(startx, starty, 0);
		//输出最短路径
		System.out.println(min);
		
	}

}
