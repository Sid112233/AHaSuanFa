package com.sixth;

import java.util.Scanner;
//Dijkstra�㷨������һ�����㵽���������������·��
//��1�ŵ�6��Ϊ��
/*6 9
1 2 1
1 3 12 
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4*/
public class Test02 {
	//��INFΪ���޴�
		final static int INF = 999999999;//��С��int�������ֵ2147483647/2
		//��¼1�Ŷ��㵽��Щ��������·���Ѿ�ȷ��
		static int[] book = new int[101]; 
		static int n ;
		static int[][] e ;
		//��¼1�Ŷ��㵽��������ĳ�ʼ·��
		static int[] dis;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���붥�����
		n = sc.nextInt();
		dis = new int[n+1];
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
		//��ʼ��dis���飬������1�Ŷ��㵽�����������ĳ�ʼ·��
		for (int i = 1; i <= n; i++) {
			dis[i] = e[1][i];
		}
		//book�����ʼ��
		for (int i = 1; i <= n; i++) {
			book[i] = 0;
		}
		book[1] = 1;
		//Dijkstra�㷨�������
		int min;
		int u = 0;
		for (int i = 1; i < n; i++) {
			//�ҵ���1�Ŷ�������Ķ���
			min = INF;
			for (int j = 1; j <= n ; j++) {
				if (book[j] == 0 && dis[j]< min) {
					min = dis[j];//��¼��С��
					u = j;//��¼���ĸ�����
				}
			}
			book[u] = 1;//���u�Ѿ�ȷ�������·��
			//��Ŀǰ��sԴ�������uΪ��㣬������uΪ���ıߣ���ÿһ���߽����ɳڲ���	
			for (int v = 1; v <= n ; v++) {
				if (e[u][v]<INF) {
					if (dis[v] > dis[u]+e[u][v]) {
						dis[v] = dis[u]+e[u][v];
					}
				}
			}
		}
		//������ս��
		for (int i = 1; i <= n; i++) {
			System.out.println(dis[i]);
		}
	}

}
