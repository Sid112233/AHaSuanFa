package com.second;

import java.util.Scanner;

public class CatFish {
	/*
	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = {0,2,4,1,2,5,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int b[] = {0,3,1,3,5,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int headA = 1,headB = 1;
		int tailA = 7,tailB = 7;
		int c[] = new int[10];
		int temp = 0;
		while (true) {
			
			//a���е�ͷ��(��һ����)����c����
			if(headA != tailA){
				c[temp] = a[headA];
				headA++;
				temp++;
			}else{
				System.out.println("��Ϸ������A����");
				System.exit(0);
			}
			//�ж�c���Ƿ�����ͬ�������ƣ����У�������(����)֮����Ʒŵ�a�������
			for (int i = 0; i < temp-1; i++) {
				if(c[temp-1] == c[i]){
					for (int j = i; j < temp; j++) {
						a[tailA] = c[j];
						tailA++;
					}
					temp = i;
				}
			}
			//b���е�ͷ��(��һ����)����c����
			if(headB != tailB){
				c[temp] = a[headB];
				headB++;
				temp++;
			}else {
				System.out.println("��Ϸ������B����");
				print(c);
				System.exit(0);
			}
			//�ж�c���Ƿ�����ͬ�������ƣ����У�������(����)֮����Ʒŵ�b�������
			for (int i = 0; i < temp-1; i++) {
				if(c[temp-1] == c[i]){
					for (int j = i; j < temp; j++) {
						b[tailB] = c[j];
						tailB++;
					}
					temp = i;
				}
			}
		
		}
	}*/
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		Queue1 q1 = new Queue1();
		Queue1 q2 = new Queue1();
		Stack1 s = new Stack1();
		int book[] = new int[10];//������ǵ����飬���������Щ���Ѿ���������,��ֻ��1--9
		int i,t;
		//��ʼ������
		q1.head = 1; q1.tail = 1;
		q2.head = 1; q2.tail = 1;
		//��ʼ��ջ
		s.top = 0;
		//��������в���6����
		//С����6����2 4 1 2 5 6
		System.out.println("������С����6���ƣ�");
		for (i = 1; i <= 6; i++) {
			q1.date[i] = sc.nextInt();
			q1.tail++;
		}
		System.out.println("������С���6���ƣ�");
		//С���6����3 1 3 5 6 4
		for (i = 1; i <= 6; i++) {
			q2.date[i] = sc.nextInt();
			q2.tail++;
		}
		//�����в���ʱִ��ѭ��
		while (q1.head<q1.tail && q2.head<q2.tail) {
			t = q1.date[q1.head];//С������һ����
			q1.head++;//�������Ҫ����
			//�ж��������ܷ�Ӯ��
			if(book[t] == 0){//��������û������Ϊt���ƣ�С�����ֲ���Ӯ��
				s.top++;
				s.date[s.top] = t;//�Ѵ�����Ʒŵ����ϣ�����ջ
				book[t] = 1;//�������������������t����
			}else {//С������Ӯ��
				q1.date[q1.tail] = t;//�����ŰѴ�����Ʒŵ������Ƶ�ĩβ����β��
				q1.tail++;
				while (s.date[s.top] != t) {//�����Ͽ���Ӯ�������η����β
					book[s.date[s.top]] = 0;//ȡ�����
					q1.date[q1.tail] = s.date[s.top];//���η����β
					q1.tail++;
					s.top--;//ջ����һ���ƣ�����ջ����һ
				}				
			}
			
			t = q2.date[q2.head];//С�����һ����
			q2.head++;//�������Ҫ����
			//�ж��������ܷ�Ӯ��
			if(book[t] == 0){//��������û������Ϊt���ƣ�С����ֲ���Ӯ��
				s.top++;
				s.date[s.top] = t;//�Ѵ�����Ʒŵ����ϣ�����ջ
				book[t] = 1;//�������������������t����
			}else {//С�����Ӯ��
				q2.date[q2.tail] = t;//�����ŰѴ�����Ʒŵ������Ƶ�ĩβ����β��
				q2.tail++;
				while (s.date[s.top] != t) {//�����Ͽ���Ӯ�������η����β
					book[s.date[s.top]] = 0;//ȡ�����
					q2.date[q2.tail] = s.date[s.top];//���η����β
					q2.tail++;
					s.top--;//ջ����һ���ƣ�����ջ����һ
				}				
			}
		}
		//�ж�˭��˭Ӯ
		if(q2.head == q2.tail){
			System.out.println("С��Ӯ");
			System.out.print("С����ǰ���е�����:");
			for ( i = q1.head; i <= q1.tail-1; i++) {
				System.out.print(q1.date[i] + " ");
			}
			System.out.println();
			if(s.top > 0){//�����������������
				System.out.print("���ϵ�����:");
				for ( i = 1; i <= s.top; i++) {
					System.out.print(s.date[i] + " ");
				}
			}else {
				System.out.print("�����Ѿ�û������");
			}
		}else {
			System.out.println("С��Ӯ");
			System.out.print("С�쵱ǰ���е�����:");
			for ( i = q2.head; i <= q2.tail-1; i++) {
				System.out.print(q2.date[i] + " ");
			}
			System.out.println();
			if(s.top > 0){//�����������������
				System.out.print("���ϵ�����:");
				for ( i = 1; i <= s.top; i++) {
					System.out.print(s.date[i] + " ");
				}
			}else {
				System.out.print("�����Ѿ�û������");
			}
		}
		
	}
	
}
//����һ������ʵ�ֶ���
class Queue1{
	int date[] = new int[1000];
	int head;
	int tail;
}
//����һ����ʵ��ջ
class Stack1{
	int date[] = new int[10];
	int top;
}


