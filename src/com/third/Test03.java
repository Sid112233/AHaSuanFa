package com.third;
//������ʽ�� ������24�����������a+b=c
public class Test03 {
	public static int fun(int x) {
		int count = 0;
		int[] arr = {6,2,5,5,4,5,6,3,7,6};//��¼0-9�ֱ��Ӧ�Ļ�������
		while (x/10 != 0){
			count += arr[x%10];//ȡ��λ���������������
			x /= 10;//ȥ��ĩβһ����
		} 
		count += arr[x];
		return count;
	}
	public static void main(String[] args) {
		int a,b,c,m,i,sum=0;
		m = 24;//�����������
		for (a = 0; a <= 1111; a++) {
			for (b = 0; b <= 1111; b++) {
				c = a + b;
				if(fun(a) + fun(b) +fun(c) == m-4){//����֮�͵���m-4
					System.out.println(a + "+" + b + "=" + c);
					sum++;
				}
			}
		}
		System.out.println("һ�������ҳ�"+sum+"�ֲ�ͬ�ĵ�ʽ");
	}

}
