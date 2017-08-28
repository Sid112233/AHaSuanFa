package com.fifth;

import java.util.Arrays;
import java.util.Scanner;
/*
5 8 
1 2 2
1 5 10
2 3 3
2 5 7
3 1 4
3 4 4
4 5 5
5 3 3
*/
//����ͼ�����·��
//ʹ��������ȱ���
public class Test02 {
	static int min = 99999999;
	static int[] book = new int[101]; 
	static int n ;
	static int[][] e  ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���붥�����
		n = sc.nextInt();
		//��ʼ����ά����
		//0��0�в��㡣
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
		//���붥��֮��ı�
		int m;//��m����
		m = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			//a��b�ĵ��򳤶�Ϊnum
			int a = sc.nextInt();
			int b = sc.nextInt();
			int num = sc.nextInt();
			e[a][b] = num;
		}
//		for (int i = 0; i < e.length; i++) {
//			System.out.println(Arrays.toString(e[i]));
//		}
		//��1�ų��п�ʼ������0��ʾ��ǰ�Ѿ��߹���·��
		book[1] = 1;
		dfs(1,0);
		//��ӡ1�ų��е�5�ų��е����·��
		System.out.println(min);
	}
	private static void dfs(int cur, int dis) {
		//�����ǰ�߹���·�̴���֮ǰ�ҵ������·����û�б�Ҫ�����³����ˣ���������
		if (dis>min) {
			return;
		}
		//�ж��Ƿ񵽴���Ŀ�����
		if (cur == n) {
			System.out.println("dis:" + dis);
			if (dis < min) {//������Сֵ
				min = dis;
				return ;
			}
		}
		//��1�ų��е�n�ų������γ���
		for (int i = 1; i < e.length; i++) {
			//������ǰ����cur������i�Ƿ��б���������δ����
			if (e[cur][i] > 0 && book[i] == 0) {
				System.out.print(e[cur][i]+" ");
				//��·�̼��ϣ���ȥ������һ������
				dfs(i, dis+e[cur][i]);
				book[i] = 1;
				//֮ǰһ��̽����֮��ȡ���Գ���i�ı��
				book[i] = 0;
			}
		}
	}

}
