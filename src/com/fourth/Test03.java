package com.fourth;

import java.util.ArrayList;
import java.util.List;
//广度优先搜索
class Note{
	int x;//横坐标
	int y;//纵坐标
	int f;//父亲在队列中的编号
	int s;//步数
	public Note(int x,int y,int f,int s) {
		this.x = x;
		this.y = y;
		this.f = f;
		this.s = s;
	}
}
public class Test03 {
	public static void main(String[] args) {
		List<Note> l = new ArrayList<Note>(100);
		int n = 5;//行
		int m = 4;//列
		int a[][] = new int[][]{{1,1,1,1,1},//第0行第0列表示地图外
								{1,0,0,1,0},
								{1,0,0,0,0},
								{1,0,0,1,0},
								{1,0,1,0,0},
								{1,0,0,0,1}}; 
		int book[][] = new int[51][51];
		//定义一个用于走的方向的数组
		int next[][] = {{0,1},//向右走
						{1,0},//向下走
						  {0,-1},//向左走
						 	{-1,0}};//向上走
		//读入起点
		int startx = 1;
		int starty = 1;
		//读入终点
		int p = 4;
		int q = 3;
		int head,tail;
		//队列初始化
		l.add(new Note(0, 0, 0, 0));//占第0个位置
		head = 1; tail = 1;
		//往队列插入迷宫入口坐标
		l.add(new Note(1,1,0,0));
		tail++;
		book[startx][starty] = 1;
		
		int flag = 0;//用来标记是否到达目标点，0表示暂时没到达，1表示到达
		int tx,ty;//下一个点的坐标
		while (head<tail) {//当队列不为空时循环
			for (int i = 0; i <= 3; i++) {
				//计算下一个点的坐标
				tx = l.get(head).x + next[i][0];
				ty = l.get(head).y + next[i][1];
				//判断是否越界
				if (tx<1 || tx>n || ty<1 || ty>m) {
					continue;
				}
				//判断是否是障碍物或已经出现在路径中
				if (a[tx][ty] == 0 && book[tx][ty] == 0)  {
					//把这个点标记为已经走过
					//宽度优先搜索不需还原book数组
					book[tx][ty] = 1;
					//插入新的点到队列中
					l.add(new Note(tx, ty, head, l.get(head).s+1));//步数是父亲的步数+1
					tail++;
				}
				//如果目标点到了，停止扩展，任务结束，退出循环
				if (tx == p && ty == q) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
			head++;//一个点扩展完后，head++才能对下一个点继续扩展
		}
		
		//打印
		System.out.println(l.get(tail-1).s);

	}

}
