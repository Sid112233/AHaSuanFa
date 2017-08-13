package com.fourth;

import java.util.ArrayList;
import java.util.List;

class Note2{
	int x;//������,�ڼ���
	int y;//�����꣬�ڼ���
	public Note2(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
 
public class Test04 {
	static int[][] a;
	public static void main(String[] args) {
		List<Note2> list = new ArrayList<Note2>(100);
		list.add(new Note2(0,0));//ռ��λ��
		int head = 1, tail = 1;
		//������Ϸ��ͼ��#����ǽ��G������ˣ�.����յ�
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
		//����һ�������ߵķ��������
		int next[][] = {{0,1},//������
						{1,0},//������
						  {0,-1},//������
						 	{-1,0}};//������
		int startx = 3;
		int starty = 3;
		//��ʼ���������
		list.add(new Note2(startx, starty));
		tail++;
		book[startx][starty] = 1;//��Ǵ�λ���߹�
		int sum = 0;
		int max = getNum(startx, starty);//��¼����λ������ɱ�����˵����ֵ
		int mx = startx;
		int my = starty;
		int tx = 0;
		int ty = 0;
		//���в�Ϊ��ʱִ��ѭ��
		while(head<tail){
			for (int i = 0; i < 4; i++) {
				tx =list.get(head).x + next[i][0];
				ty =list.get(head).y + next[i][1];
				//�ж��Ƿ�Խ��
				if (tx < 0 || tx > a.length-1 || ty < 0 || ty > a[0].length-1  ) {
					continue;
				}
				//��ƽ��������û�߹�
				if (a[tx][ty] ==  '.' && book[tx][ty] == 0) {
					//����в����µ���չ��
					list.add(new Note2(tx, ty));
					tail++;
					book[tx][ty] = 1;
					//ͳ�Ƶ�ǰ�������ĵ�����
					sum = getNum(tx, ty);
					if (sum > max) {//����ǰͳ��������ĵ���������max�������max,����¼�˵�����
						max = sum;
						mx = tx;
						my = ty;
					}
					
				}			
			}
			head++;
		}
		System.out.println("��ը��������["+mx+","+my+"]����������"+max+"������");
		
	}
	public static int getNum(int i,int j) {
		int sum = 0;//��������
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
