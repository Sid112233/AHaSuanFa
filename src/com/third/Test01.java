package com.third;
/*ö�ٷ�
ʹ***+***=***��������1-9�*�У������ظ�����������Ϲ��м���
����򻯳�*+*=*
*/
public class Test01 {

	public static  void main(String[] args) {
		int a[] = new int[4];
		int book[] = new int[4];
		int sum;
		int count = 0;
		for (a[1] = 1; a[1] <= 3; a[1]++){
			for (a[2] = 1; a[2] <= 3; a[2]++){
				for (a[3] = 1; a[3] <= 3; a[3]++){
					
						for (int i = 0; i <= 3; i++) {
							book[a[i]] = 1;//ĳ�������ֹ��ͱ����
						}
						sum = 0;//ͳ�Ƴ����˶��ٸ���
						for (int i = 1; i <= 3; i++) {
							sum += book[i];
						}
						if(sum==3 && a[1]+a[2]==a[3]){				
							System.out.println(a[1]+"+"+a[2]+"="+a[3]);
							count++;
						}
					
				}
			}
		}
		System.out.println("count:"+count/2);//����1+2=3��2+1=3����ȵ�
	}

}
