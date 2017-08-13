//使用栈判断字符串是否是回文(对称)
package com.second;

public class Stack {
	public static void main(String[] args) {
		char a[] = {'a','a','b','a','a'};
		int len = a.length;
		int mid = len/2 - 1;
		char s[] = new char[101];
		int top =0,i;
		
		//前一半字符串入栈
		for (i = 0; i <= mid; i++) {
			s[++top] = a[i];
		}
		//判断是奇数还是偶数
		int next;
		if (len%2 == 0) {
			next = mid+1;
		}else{
			next = mid+2;
		}
		//让字符串出栈并按顺序与原来字符串的后一半对比
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
