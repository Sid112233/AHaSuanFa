package com.fourth;

import java.util.Arrays;
//��ͼ�ж�����ͼ
public class Test05_03 {
	static int a[][];
	static int book[][] = new int[51][51];
	static int sum;

	static void dfs(int x, int y,int color) {
		int next[][] = { { 0, 1 }, // ������
				{ 1, 0 }, // ������
				{ 0, -1 }, // ������
				{ -1, 0 } };// ������
		int tx, ty;
		a[x][y] = color;//��a[x][y]������ӽ���Ⱦɫ
		// ö���ĸ�����
		for (int i = 0; i < 4; i++) {
			// ������һ������
			tx = x + next[i][0];
			ty = y + next[i][1];
			// �ж��Ƿ�Խ��
			if (tx < 0 || tx > a.length-1 || ty < 0 || ty > a[0].length-1) {
				continue;
			}
			// �ж��Ƿ���½��
			if (a[tx][ty] > 0 && book[tx][ty] == 0) {
				book[tx][ty] = 1;
				sum++;
				dfs(tx, ty, color);// ������һ����
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
		int num = 0;//Ⱦɫ����ɫ���
		//��ÿ������0�ĵ㳢��dfsȾɫ
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j]>0) {
//					ÿ����Ⱦ��ͬ����ɫ,���ÿ��-1
					num--;
					book[i][j] = 1;
					dfs(i, j, num);
				}
			}
		}
		//���Ⱦɫ��ĵ�ͼ
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		//���С������
		System.out.println("С������:"+(-num)+"��");
	}
}
