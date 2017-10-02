package com.sixth;

import java.util.Scanner;
//Floyd-Warshall�㷨�������������·��(�޸�Ȩ��)
/*DemoData
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12*/
public class Test01 {
	//��INFΪ���޴�
	final static int INF = 999999999;//��С��int�������ֵ2147483647/2
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
					e[i][j] = INF;
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
		//Floyd-Warshall�㷨�������
		//������ʾ ��һ��ֻ��ͨ��1�ų�����ת
		// �ڶ���ֻ��ͨ��1�ų���,2�ų�����ת���Դ�����
		for (int k = 1; k <=n; k++) {
			//��ʾ������
			for (int i = 1; i <= n; i++) {
				//��ʾĿ�ĵ�
				for (int j = 1; j <= n; j++) {
					//���i��j��·�� > iͨ��k��ת��j��·��
					if (e[i][j] > e[i][k] +e[k][j]) {
						e[i][j] = e[i][k] +e[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(e[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
