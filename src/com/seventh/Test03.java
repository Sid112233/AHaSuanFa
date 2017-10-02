package com.seventh;

import java.util.Arrays;
import java.util.Scanner;
/*
 创建最小堆
 堆排序（建立最大堆会使堆排序效率更高）
14
99 5 36 7 22 17 46 12 2 19 25 28 1 92
*/
public class Test03 {
	static int num;//节点数
	static int n;
	static int[] h;//树的所有节点
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		n = num;
		h = new int[num+1];
		h[0] = 9999999;
		for (int i = 1; i <= num; i++) {
			h[i] = sc.nextInt();
//			shiftUp(i);//时间复杂度O(NlogN)
		}
		//建堆
		creat();
		System.out.println(Arrays.toString(h));
		/*堆排序*/
		//删除顶部元素，连续删除n次，其实也就是从小到大把数输出来
		for (int i = 1; i <= num; i++) {
			System.out.print(deleteMax()+" ");
		}
	}
	
	//建立堆
	public static void creat() {
		for (int i=n/2; i>=1; i--) {
			siftDown(i);//时间复杂度O(N)
		}
		
	}
	public static void siftDown(int i) {
		//传入一个需要向下调整的节点编号i。本例传入1，即从堆的顶点开始向下调整
		int t= 0;
		int flag = 0;//用来标记是否需要向下调整
//		当i节点至少有左孩子，并且需要继续调整的时候，循环就执行
		while ( i * 2 <=n &&flag ==0) {
			//首先判断它和左儿子的关系，并用t记录较小的节点编号
			if (h[i]>h[i*2]) {
				t = i*2;
			}else {
				t = i;
			}
			//如果它有右儿子，再对右儿子进行讨论
			if (i*2+1<=n) {
				//如果右儿子的值更小，更新较小的节点编号
				if (h[t] > h[i*2+1]) {
					t = i*2+1;
				}
			}
			//如果发现最小的节点编号不是自己，说明子节点中有比父节点更小的
			if (t!=i) {
				swap(t,i);//交换他们
				i=t;//更新i为刚才与它交换的儿子节点的编号，便于接下来的继续调整
			}else {
				flag = 1;//否则说明当前的父节点已经比里那个子节点更小了，不需要再进行调整了
			}
		}
	}
	public static void siftUp(int i) {
		//传入一个需要向上调整的节点编号i。
		int t= 0;
		int flag = 0;//用来标记是否需要向上调整
		//如果在堆顶，就不用调整了
		if (i==1) {
			return;
		}
//		不在堆顶，并且当前节点i的值比父节点小的时候就需要向上调整
		while ( i!=1 &&flag ==0) {
			//判断是否比父节点小
			if (h[i]<h[i/2]) {
				swap(i, i/2);//交换他和爸爸的位置
			}else {
				flag = 1;//表示无需再调整
			}
			i = i/2;//更新编号i为它父节点的编号
		}
	}
	//删除最小的元素
	public static int deleteMax() {
		int t = h[1];//用一个临时变量记录顶点的值
		h[1] = h[n];
		n--;//堆的元素减少1
		siftDown(1);//向下调整
		return t;//返回之前记录的堆的顶点的最小值
	}
	private static void swap(int t, int i) {
		int temp = h[t];
		h[t] = h[i];
		h[i] = temp;
	}

}
