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
		System.out.println("������Ҫ���뼸����:");
		int n = sc.nextInt();
		System.out.println("������"+n+"����");
		for (i = 1; i <= n; i++) {//����n����
			data[i] = sc.nextInt(); 
		}
		len = n;
		//��ʼ������right
		for (i = 1; i <= n; i++) {
			if (i!=n) {
				right[i] = i+1;
			}else {
				right[i] = 0;
			}
		}
		//ֱ��������data���ݲ��ֵ�ĩβ����һ����
		len++;
		data[len] = sc.nextInt();
		//�������ͷ����ʼ����
		t = 1;
		while (t != 0) {
			if(data[right[t]] > data[len]){//�����ǰ�ڵ���һ���ڵ��ֵ���ڴ��������������嵽�м�
				right[len] = right[t];//�²���������һ���ڵ��ŵ��ڵ�ǰ�ڵ����һ���ڵ���
				right[t] = len;//��ǰ�ڵ����һ���ڵ��ž����²������ı��
				break;//�����������ѭ��
			}
			t = right[t];
		}
		//������������е���
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
