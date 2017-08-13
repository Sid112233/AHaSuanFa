package com.fourth;

import java.util.ArrayList;
import java.util.List;

class Note2{
	int x;//横坐标,第几行
	int y;//纵坐标，第几列
	public Note2(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
 
public class Test04 {
	static int[][] a;
	public static void main(String[] args) {
		List<Note2> list = new ArrayList<Note2>(100);
		list.add(new Note2(0,0));//占个位置
		int head = 1, tail = 1;
		//载入游戏地图，#代表墙，G代表敌人，.代表空地
		a = new int[][] {
				{'#','#','#','#','#','#','#','#','#','#','#','#','#'},
				{'#','G','G','.','G','G','G','#','G','G','G','.','#'},
				{'#','#','#','.','#','G','#','G','#','G','#','G','#'},
				{'#','.','.','.','.','.','.','.','#','.','.','G','#'},
				{'#','G','#','.','#','#','#','.','#','G','#','G','#'},
				
				{'#','G','G','.','G','G','G','.','#','.','G','G','#'},
				{'#','G','#','.','#','G','#','.','#','.','#','.','#'},
				{'#','#','G','.','.','.','G','.','.','.','.','.','#'},
				{'#','G','#','.','#','G','#','#','#','.','#','G','#'},
				{'#','.','.','.','G','#','G','G','G','.','G','G','#'},
				
				{'#','G','#','.','#','G','#','G','#','.','#','G','#'},
				{'#','G','G','.','G','G','G','#','G','.','G','G','#'},
				{'#','#','#','#','#','#','#','#','#','#','#','#','#'}
		};
		int book[][] = new int[20][20];
		//定义一个用于走的方向的数组
		int next[][] = {{0,1},//向右走
						{1,0},//向下走
						  {0,-1},//向左走
						 	{-1,0}};//向上走
		int startx = 3;
		int starty = 3;
		//起始坐标入队列
		list.add(new Note2(startx, starty));
		tail++;
		book[startx][starty] = 1;//标记此位置走过
		int sum = 0;
		int max = getNum(startx, starty);//记录各个位置中能杀死敌人的最大值
		int mx = startx;
		int my = starty;
		int tx = 0;
		int ty = 0;
		//队列不为空时执行循环
		while(head<tail){
			for (int i = 0; i < 4; i++) {
				tx =list.get(head).x + next[i][0];
				ty =list.get(head).y + next[i][1];
				//判断是否越界
				if (tx < 0 || tx > a.length-1 || ty < 0 || ty > a[0].length-1  ) {
					continue;
				}
				//是平地且曾经没走过
				if (a[tx][ty] ==  '.' && book[tx][ty] == 0) {
					//向队列插入新的扩展点
					list.add(new Note2(tx, ty));
					tail++;
					book[tx][ty] = 1;
					//统计当前点可消灭的敌人数
					sum = getNum(tx, ty);
					if (sum > max) {//若当前统计能消灭的敌人数大于max，则更新max,并记录此点坐标
						max = sum;
						mx = tx;
						my = ty;
					}
					
				}			
			}
			head++;
		}
		System.out.println("将炸弹放置在["+mx+","+my+"]处可以消灭"+max+"个敌人");
		
	}
	public static int getNum(int i,int j) {
		int sum = 0;//用来计数
		int x = i; 
		int y = j;
		while (a[x][y] != '#') {
			if (a[x][y] == 'G') {
				sum++;
			}
			x++;
		}
		x = i; y = j;
		while (a[x][y] != '#') {
			if (a[x][y] == 'G') {
				sum++;
			}
			x--;
		}
		x = i; y = j;
		while (a[x][y] != '#') {
			if (a[x][y] == 'G') {
				sum++;
			}
			y++;
		}
		x = i; y = j;
		while (a[x][y] != '#') {
			if (a[x][y] == 'G') {
				sum++;
			}
			y--;
		}
		return sum;
	}

}
