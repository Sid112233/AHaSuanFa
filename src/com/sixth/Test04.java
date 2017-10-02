package com.sixth;

import java.util.Scanner;
//Bellman-Ford�㷨�����Ż�
//ʱ�临�Ӷ����ΪO(NM)
public class Test04 {
	// ��INFΪ���޴�
	final static int INF = 999999999;// ��С��int�������ֵ2147483647/2
	// ��¼��Щ�����Ѿ��ڶ�����
	static int[] book = new int[101];
	static int n;
	// ��¼1�Ŷ��㵽��������ĳ�ʼ·��
	static int[] dis;

	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		// ���붥�����
		n = sc.nextInt();
		int[] first = new int[n + 1];
		// ��ʼ��first�����±�1-n��ֵΪ-1
		// ��ʾ1-n������ʱ��û��
		for (int i = 1; i <= n; i++) {
			first[i] = -1;
		}
		dis = new int[n + 1];

		// ���붥��֮��ı�
		int m;// ��m����
		m = sc.nextInt();
		int[] next = new int[m + 1];
		int[] u = new int[m + 1];
		int[] v = new int[m + 1];
		int[] w = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			// u[i]��v[i]�ĵ��򳤶�Ϊw[i]
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
			w[i] = sc.nextInt();
			// �����ڽӱ�Ĺؼ�
			next[i] = first[u[i]];
			first[u[i]] = i;
		}

		// ��ʼ��dis���飬������1�Ŷ��㵽�����������ĳ�ʼ·��
		for (int i = 1; i <= n; i++) {
			dis[i] = INF;
		}
		dis[1] = 0;
		// ���岢��ʼ��һ������
		int[] que = new int[101];
		int head = 1, tail = 1;

		// 1�Ŷ������
		que[tail] = 1;
		tail++;
		book[1] = 1;// ���1�Ŷ����Ѿ����
		while (head < tail) {// ���в�Ϊ�յ�ʱ��ѭ��
			k = first[que[head]];// ��ǰ��Ҫ����Ķ��׶���
			while (k != -1) {
				// �ж��Ƿ��ɳڳɹ�
				if (dis[v[k]] > dis[u[k]] + w[k]) {
					// ���¶���1�����㶥��v[k]��·��
					dis[v[k]] = dis[u[k]] + w[k];
					// 0��ʾ���ڶ����У�������v[k]���������
					if (book[v[k]] == 0) {
						// ��Ӳ���
						que[tail] = v[k];
						tail++;
						book[v[k]] = 1;// ͬʱ��Ƕ���v[k]�Ѿ����
					}
				}
				k = next[k];
			}
			// ����
			book[que[head]] = 0;
			head++;
		}
		// ������
		for (int i = 1; i <= n; i++) {
			System.out.print(dis[i] + " ");
		}
	}
}
