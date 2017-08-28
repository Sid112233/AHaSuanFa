package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//
/*��������
5 5
1 2
1 3 
1 5
2 4 
3 5
*/
//������ȱ���ͼ(�ڽӾ���)
public class Test01 {
	static int[] book = new int[101];
	static int sum , n ;
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			//��Ϊ������ͼ������˫��Ҫ��Ϊ1
			e[a][b] = 1;
			e[b][a] = 1;
		}
		
		System.out.println("�����������������");
		//��1�ų��г���
		book[1]=1;
		//1�Ŷ��㿪ʼ����
		dfs(1);
	}
	//���������������
	private static void dfs(int cur) {
		//cur����Ŀǰ�ڼ���
		System.out.print(cur+" ");
		//ÿ����һ�����㣬sum+1
		sum++;
		if (sum == n) {
			return;//���ʹ������ж�����˳�
		}
		//�������ж��㣬������ǰ����cur������i�Ƿ��б�����
		for (int i = 1; i < e.length; i++) {
			//�Ƿ��бߣ��Ƿ��Ѿ����ʹ�
			if ( book[i] == 0
					&& e[cur][i] == 1) {
				book[i] = 1;
				dfs(i);
			}
		}
		return;
	}
}
