package com.sixth;

import java.util.Scanner;
//Bellman-Ford�㷨�Ż�������һ�����㵽���������������·��
//�����Ȩ��
//ʱ�临�Ӷ����ΪO(NM)
/*
5 5
2 3 2
1 2 -3
1 5 5
4 5 2
3 4 3
*/
public class Test03_2 {
//	INFΪ���޴�
	final static int INF = 999999999;//��С��int�������ֵ2147483647/2
	static int n ;//�������
	//��¼1�Ŷ��㵽��������ĳ�ʼ·��
	static int[] dis;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//���붥�����
		n = sc.nextInt();
		dis = new int[n+1];
		int[] bak = new int [n+1];//����dis������
		
		//���붥��֮��ı�
		int m;//��m����
		m = sc.nextInt();
		int[] u = new int[m+1];
		int[] v = new int[m+1];
		int[] w = new int[m+1];
		for (int i = 1; i <= m; i++) {
			//u[i]��v[i]�ĵ��򳤶�Ϊw[i]
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
		}
		//��ʼ��dis���飬������1�Ŷ��㵽�����������ĳ�ʼ·��
		for (int i = 1; i <= n; i++) {
			dis[i] = INF;
		}
		dis[1] = 0;
		//Bellman-Ford�㷨�������
		//����n-1���ɳ�
		int check ;
		for (int k = 1; k <= n-1; k++) {
			//��dis���鱸�ݵ�bak������
			for (int i = 1; i <= n; i++) {
				bak[i] = dis[i];
			}
			//����һ���ɳ�
			for (int i = 1; i <= m; i++) {
				if (dis[v[i]] > dis[u[i]] + w[i]) {
					dis[v[i]] = dis[u[i]] + w[i];
				}
			}
			check = 0;
			//�ɳ���Ϻ���dis�����Ƿ��и���
			for (int i = 1; i < n; i++) {
				if (bak[i] != dis[i]) {
					check = 1;
					break;
				}
			}
			//���dis����û�и��£���ǰ����ѭ�������㷨
			if (check == 0) {
				break;
			}
		}
		//��⸺Ȩ��·
		//ԭ���������ͼ���и�Ȩ��·����ô��n-1���ɳ�֮�� ���е��ɳڣ�����ʹ���·���ֱ仯
		int flag = 0;
		for (int i = 1; i <= m; i++) {
			if (dis[v[i]] > dis[u[i]] + w[i]) {
				flag = 1;
			}
		}
		if (flag == 1) {
			System.out.println("��ͼ���и�Ȩ��·");
		}else {
			System.out.println("��ͼ������Ȩ��·");
		}
		//������
		for (int i = 1; i <= n; i++) {
			System.out.print(dis[i]+" ");
		}
	}

}