package com.fourth;
/*�����������
	ʹ***+***=***��������1-9�*�У������ظ�����������Ϲ��м���
*/
public class Test01_T3_01 {
	static int[] a = new int[10];
	static int[] book =  new int[10];
	static int total;
	static void dfs(int step){
		//�ж��Ƿ��������������������
		if(step == 10){//���step����10,˵��֮ǰ9��λ�ö��ź���
			if (100*a[1] + 10*a[2] +a[3] +100*a[4] + 10*a[5] +a[6]
					== 100*a[7] + 10*a[8] + a[9]) {
				total++;
				System.out.println(a[1]+" "+a[2]+" "+a[3]+" "+"+"+" "
						+a[4]+" "+a[5]+" "+a[6]+" "+"="
						+" "+a[7]+" "+a[8]+" "+a[9]);
			}
			return;//����֮ǰһ��
		}
		
		for (int i = 1; i < a.length; i++) {
			if (book[i] == 0) {//������ֻ���
				a[step] = i;//������ӷ����������
				book[i] = 1;
				//���ź��ˣ���һ��
				dfs(step+1);
				book[i] = 0;
			}		
		}
		return;
	} 

	public static void main(String[] args) {
		dfs(1);
		System.out.println("����������ʽ�ӹ���:"+total/2+"��");

	}

}
