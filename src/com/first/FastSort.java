package com.first;

import java.util.Random;

public class FastSort {
	 static int n = 10;
	 static int a[] = new int[n];
	 
	public static void main(String[] args) {
		Random rd = new Random();
		for (int i = 0; i <n ; i++) {
			a[i] = rd.nextInt(20);
			System.out.print(a[i]+" ");
		}
		
		System.out.println("----------------------");		
		quickSort(0,n-1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i]+" ");
		}
	}

	private static void quickSort(int left,int right) {
		int i,j,t,temp;
		if(left > right) return ;
		temp = a[left];//temp��Ļ�׼��
		i = left;
		j = right;
		while (i != j) {
			//��������������
			while (a[j]>=temp && i<j) {
				j--;
			}
			//�ٴ���������
			while (a[i]<=temp && i<j) {
				i++;
			}
			if(i < j){
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}						
		}
		a[left] = a[i];
		a[i] = temp;
		
		quickSort(left, i-1);//����������ߵģ����Ǹ��ݹ����
		quickSort(i+1, right);//���������ұߵģ����Ǹ��ݹ����
		
		
	}

}
