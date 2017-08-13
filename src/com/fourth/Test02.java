package com.fourth;


public class Test02 {
	static int m,n;//�У���
	static int p,q;//�յ�
	static int min=9999999;
	static int a[][];//����Ƿ�Ϊ�ϰ���
	static int book[][] = new int[51][51];//����Ƿ��߹�
	static void dfs(int x,int y,int step){
		int next[][] = {{0,1},//������
							{1,0},//������
							  {0,-1},//������
							 	{-1,0}};//������
		int tx,ty;
		//�ж��Ƿ񵽴���С����λ��
		if(x == p && y == q){
			//������Сֵ
			if (step < min) {
				min = step;
			}
			return;
		}	
		//����һ��
		for (int k = 0; k <= 3; k++) {
			//������һ���������
			tx = x + next[k][0];
			ty = y + next[k][1];
			//�ж��Ƿ�Խ�˱߽�
			if (tx<1 || tx>n || ty <1 || ty>m) {
				continue;
			}
			//�жϸõ��Ƿ�Ϊ�ϰ�����Ѿ���·����
			if (a[tx][ty]==0 && book[tx][ty] == 0) {
				book[tx][ty] = 1;//���������Ѿ��߹�
				dfs(tx, ty, step+1);//��ʼ������һ����
				book[tx][ty] = 0;//���Խ�����ȡ���˵���
			}
		}
		return;
	}
	public static void main(String[] args) {
		m = 4;//��
		n = 5;//��
		//�����Թ�
		a = new int[][]{{1,1,1,1,1},//��0�е�0�б�ʾ��ͼ��
						{1,0,0,1,0},
						{1,0,0,0,0},
						{1,0,0,1,0},
						{1,0,1,0,0},
						{1,0,0,0,1}}; 
		//�������
		int startx = 1;
		int starty = 1;
		//�����յ�
		p = 4;
		q = 3;
		book[startx][starty] = 1;//�������Ѿ���·����
		dfs(startx, starty, 0);
		//������·��
		System.out.println(min);
		
	}

}
