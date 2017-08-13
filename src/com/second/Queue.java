/*首先将第 1 个数删除，紧接着将第 2 个数放到
这串数的末尾，再将第 3 个数删除并将第 4 个数放到这串数的末尾，再将第 5 个数删除……
直到剩下最后一个数，将最后一个数也删除。按照刚才删除的顺序，把这些删除的数连在一
起*/
package com.second;

public class Queue {
	
	public static void main(String[] args) {
		int a[] = {6,3,1,7,5,8,9,2,4};
		int q[] = new int[102];
		//初始化队列
		int head = 1;//head队头，q[0]=0
		int tail = a.length+1;//tail指向队尾后一个位置
		int i;
		System.arraycopy(a, 0, q, 1, a.length);//数组复制，a[]的0开始，q[]的1下标开始,长度a.length
		
		while (head < tail) {//当队列不为空时执行循环
			//打印队首并将队首出队
			System.out.print(q[head]+" ");
			head++;
			
			//将新的队首移到队尾
			q[tail] = q[head];
			tail++;
			//再将队首出队
			head++;
		}		
	}
}
