package com.fourth;

import java.util.ArrayList;
import java.util.List;
//�����������
class Note{
	int x;//������
	int y;//������
	int f;//�����ڶ����еı��
	int s;//����
	public Note(int x,int y,int f,int s) {
		this.x = x;
		this.y = y;
		this.f = f;
		this.s = s;
	}
}
public class Test03 {
	public static void main(String[] args) {
		List<Note> l = new ArrayList<Note>(100);
		int n = 5;//��
		int m = 4;//��
		int a[][] = new int[][]{{1,1,1,1,1},//��0�е�0�б�ʾ��ͼ��
								{1,0,0,1,0},
								{1,0,0,0,0},
								{1,0,0,1,0},
								{1,0,1,0,0},
								{1,0,0,0,1}}; 
		int book[][] = new int[51][51];
		//����һ�������ߵķ��������
		int next[][] = {{0,1},//������
						{1,0},//������
						  {0,-1},//������
						 	{-1,0}};//������
		//�������
		int startx = 1;
		int starty = 1;
		//�����յ�
		int p = 4;
		int q = 3;
		int head,tail;
		//���г�ʼ��
		l.add(new Note(0, 0, 0, 0));//ռ��0��λ��
		head = 1; tail = 1;
		//�����в����Թ��������
		l.add(new Note(1,1,0,0));
		tail++;
		book[startx][starty] = 1;
		
		int flag = 0;//��������Ƿ񵽴�Ŀ��㣬0��ʾ��ʱû���1��ʾ����
		int tx,ty;//��һ���������
		while (head<tail) {//�����в�Ϊ��ʱѭ��
			for (int i = 0; i <= 3; i++) {
				//������һ���������
				tx = l.get(head).x + next[i][0];
				ty = l.get(head).y + next[i][1];
				//�ж��Ƿ�Խ��
				if (tx<1 || tx>n || ty<1 || ty>m) {
					continue;
				}
				//�ж��Ƿ����ϰ�����Ѿ�������·����
				if (a[tx][ty] == 0 && book[tx][ty] == 0)  {
					//���������Ϊ�Ѿ��߹�
					//��������������軹ԭbook����
					book[tx][ty] = 1;
					//�����µĵ㵽������
					l.add(new Note(tx, ty, head, l.get(head).s+1));//�����Ǹ��׵Ĳ���+1
					tail++;
				}
				//���Ŀ��㵽�ˣ�ֹͣ��չ������������˳�ѭ��
				if (tx == p && ty == q) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
			head++;//һ������չ���head++���ܶ���һ���������չ
		}
		
		//��ӡ
		System.out.println(l.get(tail-1).s);

	}

}
