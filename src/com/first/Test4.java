package com.first;
//С������,����ȥ�ء����о���ͬ�㷨��Ч��
public class Test4 {

	public static void main(String[] args) {
		int[] b =new int[]{1};
		int n =10;//n��ͬѧ
		int[] a = {20,40,32,67,40,20,89,300,400,15};  //ISBN���,������0-1000
		//bucketSort(a);
		//bubbleSort(a);
		quickSort(a);
	}
	//ѡ������
	private static void quickSort(int[] a) {
		int temp;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j]){
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			
		}
		for (int i = 0; i < a.length; i++) {
			if(i == 0){
				System.out.print(a[i]+" ");
			}else if(a[i] !=a[i-1]){
				System.out.print(a[i]+" ");
			}
		}
	}

	private static void bubbleSort(int[] a) {
		int temp;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			if(i == 0){
				System.out.print(a[i]+" ");
			}else if(a[i] !=a[i-1]){
				System.out.print(a[i]+" ");
			}
		}
		
	}

	private static void bucketSort(int[] a) {
		int[] b = new int[1001];
		for (int i = 0; i < a.length; i++) {
			b[a[i]]++;
		}
		for (int i = 0; i < b.length; i++) {
			if(b[i] != 0){
				System.out.print(i+" ");
			}
		}		
	}

}
