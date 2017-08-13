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
			
			//a队列的头部(第一张牌)存入c数组
			if(headA != tailA){
				c[temp] = a[headA];
				headA++;
				temp++;
			}else{
				System.out.println("游戏结束，A输了");
				System.exit(0);
			}
			//判断c中是否有相同的两张牌，若有，两张牌(包括)之间的牌放到a队列最后
			for (int i = 0; i < temp-1; i++) {
				if(c[temp-1] == c[i]){
					for (int j = i; j < temp; j++) {
						a[tailA] = c[j];
						tailA++;
					}
					temp = i;
				}
			}
			//b队列的头部(第一张牌)存入c数组
			if(headB != tailB){
				c[temp] = a[headB];
				headB++;
				temp++;
			}else {
				System.out.println("游戏结束，B输了");
				print(c);
				System.exit(0);
			}
			//判断c中是否有相同的两张牌，若有，两张牌(包括)之间的牌放到b队列最后
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
		int book[] = new int[10];//用来标记的数组，用来标记哪些牌已经在桌上了,牌只有1--9
		int i,t;
		//初始化队列
		q1.head = 1; q1.tail = 1;
		q2.head = 1; q2.tail = 1;
		//初始化栈
		s.top = 0;
		//依次向队列插入6个数
		//小明的6张牌2 4 1 2 5 6
		System.out.println("请输入小明的6张牌：");
		for (i = 1; i <= 6; i++) {
			q1.date[i] = sc.nextInt();
			q1.tail++;
		}
		System.out.println("请输入小红的6张牌：");
		//小红的6张牌3 1 3 5 6 4
		for (i = 1; i <= 6; i++) {
			q2.date[i] = sc.nextInt();
			q2.tail++;
		}
		//当队列不空时执行循环
		while (q1.head<q1.tail && q2.head<q2.tail) {
			t = q1.date[q1.head];//小明出了一张牌
			q1.head++;//打出的牌要出队
			//判断这张牌能否赢牌
			if(book[t] == 0){//表明桌上没有数字为t的牌，小明此轮不能赢牌
				s.top++;
				s.date[s.top] = t;//把打出的牌放到桌上，即入栈
				book[t] = 1;//标记桌上现在已有牌面t的牌
			}else {//小明此轮赢牌
				q1.date[q1.tail] = t;//紧接着把打出的牌放到手中牌的末尾（队尾）
				q1.tail++;
				while (s.date[s.top] != t) {//把桌上可以赢得牌依次放入队尾
					book[s.date[s.top]] = 0;//取消标记
					q1.date[q1.tail] = s.date[s.top];//依次放入队尾
					q1.tail++;
					s.top--;//栈中少一张牌，所以栈顶减一
				}				
			}
			
			t = q2.date[q2.head];//小红出了一张牌
			q2.head++;//打出的牌要出队
			//判断这张牌能否赢牌
			if(book[t] == 0){//表明桌上没有数字为t的牌，小红此轮不能赢牌
				s.top++;
				s.date[s.top] = t;//把打出的牌放到桌上，即入栈
				book[t] = 1;//标记桌上现在已有牌面t的牌
			}else {//小红此轮赢牌
				q2.date[q2.tail] = t;//紧接着把打出的牌放到手中牌的末尾（队尾）
				q2.tail++;
				while (s.date[s.top] != t) {//把桌上可以赢得牌依次放入队尾
					book[s.date[s.top]] = 0;//取消标记
					q2.date[q2.tail] = s.date[s.top];//依次放入队尾
					q2.tail++;
					s.top--;//栈中少一张牌，所以栈顶减一
				}				
			}
		}
		//判断谁输谁赢
		if(q2.head == q2.tail){
			System.out.println("小明赢");
			System.out.print("小明当前手中的牌是:");
			for ( i = q1.head; i <= q1.tail-1; i++) {
				System.out.print(q1.date[i] + " ");
			}
			System.out.println();
			if(s.top > 0){//桌上有牌则依次输出
				System.out.print("桌上的牌是:");
				for ( i = 1; i <= s.top; i++) {
					System.out.print(s.date[i] + " ");
				}
			}else {
				System.out.print("桌上已经没有牌了");
			}
		}else {
			System.out.println("小红赢");
			System.out.print("小红当前手中的牌是:");
			for ( i = q2.head; i <= q2.tail-1; i++) {
				System.out.print(q2.date[i] + " ");
			}
			System.out.println();
			if(s.top > 0){//桌上有牌则依次输出
				System.out.print("桌上的牌是:");
				for ( i = 1; i <= s.top; i++) {
					System.out.print(s.date[i] + " ");
				}
			}else {
				System.out.print("桌上已经没有牌了");
			}
		}
		
	}
	
}
//定义一个类来实现队列
class Queue1{
	int date[] = new int[1000];
	int head;
	int tail;
}
//定义一个类实现栈
class Stack1{
	int date[] = new int[10];
	int top;
}


