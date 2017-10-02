package com.seventh;

import java.util.Scanner;

/*���鼯-
10 9
1 2   3 4   5 2   4 6  2 6
8 7   9 7   1 6   2 4 
*/
public class Test04 {
	static int[] f = new int[1000];
	static int n,m,k,sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//ǿ������
		m = sc.nextInt();//�����Ѽ�������������
		
		//��ʼ��
		init();
		int x,y;
		for (int i = 1; i <= m; i++) {
			//��ʼ�ϲ������Ż�
			x = sc.nextInt();
			y = sc.nextInt();
			merge(x,y);
		}
		
		//���ɨ���ж��ٸ������ķ����Ż�
		for (int i = 1; i <= n; i++) {
			if (f[i] == i) {
				sum++;
			}
		}
		System.out.println("����"+sum+"���������Ｏ��");
		
		
	}
	//���Ǻϲ������Ӽ��ϵĺ���
	private static void merge(int v, int u) {
		int t1,t2;
		t1 = getf(v);
		t2 = getf(u);
		//�ж������ڵ��Ƿ���ͬһ�������С����Ƿ�Ϊͬһ�����ȡ�
		if (t1!=t2) {
			f[t2] = t1;
			//������ԭ�򡱣���߱���ұߵ�BOSS�������ұߵļ��ϣ���Ϊ��߼��ϵ��Ӽ��ϡ�
			//����·��ѹ��֮�󣬽�f[u]�ĸ���ֵҲ��ֵΪv������f[t1].
			
		}
	}
	//�����ҵ��ĵݹ麯������ͣ��ȥ�ҵ���ֱ���ҵ�����Ϊֹ����ʵ����ȥ��
	//�����Ż������쵼�ˡ�
	private static int getf(int v) {
		if (f[v] == v) {
			return v;
		}else {
			//������·��ѹ����ÿ���ں������ص�ʱ��˳����·���������˵ġ�BOSS����Ϊ����ҵ�
			//�����ڱ�ţ�Ҳ���Ƿ����Ż������쵼�˱�š�����������߽���ҵ������Ż��
			//����쵼��(Ҳ������������)���ٶ�
			f[v] = getf(f[v]);
			return f[v];
		}
	}
	//��ʼ��
	private static void init() {
		for (int i = 1; i <= n; i++) {
			f[i] = i;
		}
	}

}
