package com.fourth;

import java.util.LinkedList;
import java.util.List;

class Note3{
	int x;//第几行
	int y;//第几列
	public  Note3(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Test05 {

	public static void main(String[] args) {
		List<Note3> list = new LinkedList<Note3>();
		//载入地图
		int[][] a = new int[][]{
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
		int[][] next = {
				{0,1},//向右
				{1,0},//向下
				{0,-1},//向左
				{-1,0}//向上
		};
		int tx = 0,ty = 0;
		int book[][] = new int[20][20];
		//起始坐标
		int startx = 5;//第6行
		int starty = 7;//第8列
		
		list.add(new Note3(startx, starty));
		book[startx][starty] = 1;
		int num = 1;
		while(list.size() != 0){//队列不为空时循环
			for (int i = 0; i < 4; i++) {
				//下一步坐标
				tx = list.get(0).x + next[i][0];
				ty = list.get(0).y + next[i][1];
				//判断是否在地图外
				if (tx<0 || tx>a.length-1 || ty<0 || ty>a[0].length-1 ) {
					continue;
				}
				//判断是否是陆地且有没有走过
				if (a[tx][ty] > 0  && book[tx][ty] == 0) {
					list.add(new Note3(tx, ty));
					book[tx][ty] = 1;
					num++;
				}
			}
			list.remove(0);
		}
		System.out.println(num);
	}

}
