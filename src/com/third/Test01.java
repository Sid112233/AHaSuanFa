package com.third;
/*枚举法
使***+***=***，将数字1-9填到*中，不得重复，这样的组合共有几个
这里简化成*+*=*
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
							book[a[i]] = 1;//某个数出现过就标记下
						}
						sum = 0;//统计出现了多少个数
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
		System.out.println("count:"+count/2);//形如1+2=3与2+1=3是相等的
	}

}
