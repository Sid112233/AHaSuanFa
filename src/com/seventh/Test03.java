package com.seventh;

import java.util.Arrays;
import java.util.Scanner;
/*
 ������С��
 �����򣨽������ѻ�ʹ������Ч�ʸ��ߣ�
14
99 5 36 7 22 17 46 12 2 19 25 28 1 92
*/
public class Test03 {
	static int num;//�ڵ���
	static int n;
	static int[] h;//�������нڵ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		n = num;
		h = new int[num+1];
		h[0] = 9999999;
		for (int i = 1; i <= num; i++) {
			h[i] = sc.nextInt();
//			shiftUp(i);//ʱ�临�Ӷ�O(NlogN)
		}
		//����
		creat();
		System.out.println(Arrays.toString(h));
		/*������*/
		//ɾ������Ԫ�أ�����ɾ��n�Σ���ʵҲ���Ǵ�С������������
		for (int i = 1; i <= num; i++) {
			System.out.print(deleteMax()+" ");
		}
	}
	
	//������
	public static void creat() {
		for (int i=n/2; i>=1; i--) {
			siftDown(i);//ʱ�临�Ӷ�O(N)
		}
		
	}
	public static void siftDown(int i) {
		//����һ����Ҫ���µ����Ľڵ���i����������1�����ӶѵĶ��㿪ʼ���µ���
		int t= 0;
		int flag = 0;//��������Ƿ���Ҫ���µ���
//		��i�ڵ����������ӣ�������Ҫ����������ʱ��ѭ����ִ��
		while ( i * 2 <=n &&flag ==0) {
			//�����ж���������ӵĹ�ϵ������t��¼��С�Ľڵ���
			if (h[i]>h[i*2]) {
				t = i*2;
			}else {
				t = i;
			}
			//��������Ҷ��ӣ��ٶ��Ҷ��ӽ�������
			if (i*2+1<=n) {
				//����Ҷ��ӵ�ֵ��С�����½�С�Ľڵ���
				if (h[t] > h[i*2+1]) {
					t = i*2+1;
				}
			}
			//���������С�Ľڵ��Ų����Լ���˵���ӽڵ����бȸ��ڵ��С��
			if (t!=i) {
				swap(t,i);//��������
				i=t;//����iΪ�ղ����������Ķ��ӽڵ�ı�ţ����ڽ������ļ�������
			}else {
				flag = 1;//����˵����ǰ�ĸ��ڵ��Ѿ������Ǹ��ӽڵ��С�ˣ�����Ҫ�ٽ��е�����
			}
		}
	}
	public static void siftUp(int i) {
		//����һ����Ҫ���ϵ����Ľڵ���i��
		int t= 0;
		int flag = 0;//��������Ƿ���Ҫ���ϵ���
		//����ڶѶ����Ͳ��õ�����
		if (i==1) {
			return;
		}
//		���ڶѶ������ҵ�ǰ�ڵ�i��ֵ�ȸ��ڵ�С��ʱ�����Ҫ���ϵ���
		while ( i!=1 &&flag ==0) {
			//�ж��Ƿ�ȸ��ڵ�С
			if (h[i]<h[i/2]) {
				swap(i, i/2);//�������Ͱְֵ�λ��
			}else {
				flag = 1;//��ʾ�����ٵ���
			}
			i = i/2;//���±��iΪ�����ڵ�ı��
		}
	}
	//ɾ����С��Ԫ��
	public static int deleteMax() {
		int t = h[1];//��һ����ʱ������¼�����ֵ
		h[1] = h[n];
		n--;//�ѵ�Ԫ�ؼ���1
		siftDown(1);//���µ���
		return t;//����֮ǰ��¼�ĶѵĶ������Сֵ
	}
	private static void swap(int t, int i) {
		int temp = h[t];
		h[t] = h[i];
		h[i] = temp;
	}

}
