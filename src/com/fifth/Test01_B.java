package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//������ȱ���ͼ(�ڽӾ���)
public class Test01_B {
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
			int a = sc.nextInt();
			int b = sc.nextInt();
			//��Ϊ������ͼ������˫��Ҫ��Ϊ1
			e[a][b] = 1;
			e[b][a] = 1;
		}
		
		System.out.println("�����������������");
		method();
	}
	private static void method() {
		//1�Ŷ��㿪ʼ����
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		book[1] = 1;
		//����Ϊ��˵����������
		while (!arrayList.isEmpty()) {
			//��ǰ���ʵĶ���
			int first = arrayList.get(0);
			System.out.print(first+" ");
			arrayList.remove(0);
			//�������ж��㣬������ǰ����cur������i�Ƿ��б�����
			for (int i = 1; i < e.length; i++) {
				if (e[first][i] == 1 && book[i] == 0) {
					arrayList.add(i);
					book[i] = 1;
				}
			}
		}
	}

}
