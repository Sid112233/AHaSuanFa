/*���Ƚ��� 1 ����ɾ���������Ž��� 2 �����ŵ�
�⴮����ĩβ���ٽ��� 3 ����ɾ�������� 4 �����ŵ��⴮����ĩβ���ٽ��� 5 ����ɾ������
ֱ��ʣ�����һ�����������һ����Ҳɾ�������ող�ɾ����˳�򣬰���Щɾ����������һ
��*/
package com.second;

public class Queue {
	
	public static void main(String[] args) {
		int a[] = {6,3,1,7,5,8,9,2,4};
		int q[] = new int[102];
		//��ʼ������
		int head = 1;//head��ͷ��q[0]=0
		int tail = a.length+1;//tailָ���β��һ��λ��
		int i;
		System.arraycopy(a, 0, q, 1, a.length);//���鸴�ƣ�a[]��0��ʼ��q[]��1�±꿪ʼ,����a.length
		
		while (head < tail) {//�����в�Ϊ��ʱִ��ѭ��
			//��ӡ���ײ������׳���
			System.out.print(q[head]+" ");
			head++;
			
			//���µĶ����Ƶ���β
			q[tail] = q[head];
			tail++;
			//�ٽ����׳���
			head++;
		}		
	}
}
