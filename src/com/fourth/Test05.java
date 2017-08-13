package com.fourth;

import java.util.LinkedList;
import java.util.List;

class Note3{
	int x;//�ڼ���
	int y;//�ڼ���
	public  Note3(int x,int y) {
		this.x = x;
		this.y = y;
	}
}

public class Test05 {

	public static void main(String[] args) {
		List<Note3> list = new LinkedList<Note3>();
		//�����ͼ
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
				{0,1},//����
				{1,0},//����
				{0,-1},//����
				{-1,0}//����
		};
		int tx = 0,ty = 0;
		int book[][] = new int[20][20];
		//��ʼ����
		int startx = 5;//��6��
		int starty = 7;//��8��
		
		list.add(new Note3(startx, starty));
		book[startx][starty] = 1;
		int num = 1;
		while(list.size() != 0){//���в�Ϊ��ʱѭ��
			for (int i = 0; i < 4; i++) {
				//��һ������
				tx = list.get(0).x + next[i][0];
				ty = list.get(0).y + next[i][1];
				//�ж��Ƿ��ڵ�ͼ��
				if (tx<0 || tx>a.length-1 || ty<0 || ty>a[0].length-1 ) {
					continue;
				}
				//�ж��Ƿ���½������û���߹�
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
