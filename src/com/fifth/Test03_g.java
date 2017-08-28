package com.fifth;

import java.util.ArrayList;
import java.util.Scanner;
//������Сת��������ʹ�ù����������
/*5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5
*/
public class Test03_g {
	static int[] book = new int[101];
	static int sum , n ;
	static int[][] e  ;
	public static void main(String[] args) {
		//���еĳ�ʼ������
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
		//����֮��ĺ���
		int m;//��m������
		m = sc.nextInt();
//		��ʼ����
		int start = sc.nextInt();
		int end = sc.nextInt();
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			//��Ϊ������ͼ������˫��Ҫ��Ϊ1
			e[a][b] = 1;
			e[b][a] = 1;
		}
		
		ArrayList<Note> list = new ArrayList<>();
		//��start���г�����0Ϊת������
		
		list.add(new Note(start,0));
		book[start] = 1;
		int cur;
		while (!list.isEmpty()) {
			//��ǰ���׳���(���¼���)���
			int lastIndex = list.size()-1;
			cur = list.get(lastIndex).x;
//			System.out.println("cur:"+cur);
			for (int i = 1; i < e.length; i++) {
				//�ж��Ƿ��к��ߣ��Լ��Ƿ񵽴���������
				if (e[cur][i] == 1 && book[i] == 0) {
					book[i] = 1;
//					System.out.println(list.get(lastIndex).s+1);
					list.add(new Note(i, list.get(lastIndex).s+1));
				}
			}
			if (list.get(list.size()-1).x == end) {
		
				break;
			}
		}
		System.out.println("����ת������"+list.get(list.size()-1).s);
	}
}
class Note {
	int x;//���б��
	int s;//ת������
	public Note(int x, int s) {
		super();
		this.x = x;
		this.s = s;
	}
}
