//ʹ��ջ�ж��ַ����Ƿ��ǻ���(�Գ�)
package com.second;

public class Stack {
	public static void main(String[] args) {
		char a[] = {'a','a','b','a','a'};
		int len = a.length;
		int mid = len/2 - 1;
		char s[] = new char[101];
		int top =0,i;
		
		//ǰһ���ַ�����ջ
		for (i = 0; i <= mid; i++) {
			s[++top] = a[i];
		}
		//�ж�����������ż��
		int next;
		if (len%2 == 0) {
			next = mid+1;
		}else{
			next = mid+2;
		}
		//���ַ�����ջ����˳����ԭ���ַ����ĺ�һ��Ա�
		for ( i = next ; i <= len-1; i++) {
			if(a[i] != s[top]){
				break;
			}
			top--;
		}
		if(top == 0){
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}		
	}

}
