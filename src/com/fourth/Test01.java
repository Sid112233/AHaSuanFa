package com.fourth;

import java.util.Scanner;
//����������������N�����ֵ�ȫ����
public class Test01 {
	static int[] a = new int[10];
	static int[] book = new int[10];
	static int n;
	static void dfs(int step){//step��ʾ�ڵڼ�������ǰ
		int i;
		if(step == n+1){//���վ��n+1������ǰ������ǰ��n�������Ѿ��ź��˿�
			//���һ��ȫ����
			for (i = 1; i <= n; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;//����֮ǰ��һ��
		}
		
		//��ʱվ�ڵ�step��������ǰ,Ӧ�÷������ƣ�
		//����1��2��3..n��˳����
		for (i = 1; i <= n; i++) {
			//�ж��˿����Ƿ�������
			if (book[i] == 0) {//��ʾi���˿��ƻ�������
				//��ʼ����ʹ���˿���i
				a[step] = i;//��i���˿��Ʒŵ���step��������
				book[i] = 1;//��ʾi���˿����Ѿ���������
				
				//��step�������Ѿ��ź��˿��ƣ���������Ҫ��step��������ǰ
				dfs(step+1);
				book[i] = 0;//����Ҫ�������˿�
				
			}
		}
		
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//����1-9������
		dfs(1);

	}

}
