package com.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	int id;
	int data;
	int nextId;
}
public class LinkList {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int data[] = new int[101];
		int right[] = new int[101];
		int i,t,len;
		System.out.println("请问你要输入几个数:");
		int n = sc.nextInt();
		System.out.println("请输入"+n+"个数");
		for (i = 1; i <= n; i++) {//读入n个数
			data[i] = sc.nextInt(); 
		}
		len = n;
		//初始化数组right
		for (i = 1; i <= n; i++) {
			if (i!=n) {
				right[i] = i+1;
			}else {
				right[i] = 0;
			}
		}
		//直接在数组data数据部分的末尾增加一个数
		len++;
		data[len] = sc.nextInt();
		//从链表的头部开始遍历
		t = 1;
		while (t != 0) {
			if(data[right[t]] > data[len]){//如果当前节点下一个节点的值大于待插入数，将数插到中间
				right[len] = right[t];//新插入数的下一个节点标号等于当前节点的下一个节点编号
				right[t] = len;//当前节点的下一个节点编号就是新插入数的编号
				break;//插入完成跳出循环
			}
			t = right[t];
		}
		//输出链表中所有的数
		t = 1;
		while (t !=0) {
			System.out.print(data[t]+" ");
			t = right[t];
		}		
						
//		List<Node> nodes = new ArrayList<Node>();
//		
//		for (int j = 0; j < 100; j++) {
//			Node node = new Node();
//			nodes.add(node);
//		}
//		
//		for (Node node : nodes) {
//			System.out.println(node.toString());
//		}

	}

}
