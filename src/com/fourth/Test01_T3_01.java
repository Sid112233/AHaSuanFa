package com.fourth;
/*深度优先搜索
	使***+***=***，将数字1-9填到*中，不得重复，这样的组合共有几个
*/
public class Test01_T3_01 {
	static int[] a = new int[10];
	static int[] book =  new int[10];
	static int total;
	static void dfs(int step){
		//判断是否满足条件，满足则输出
		if(step == 10){//如果step等于10,说明之前9个位置都放好了
			if (100*a[1] + 10*a[2] +a[3] +100*a[4] + 10*a[5] +a[6]
					== 100*a[7] + 10*a[8] + a[9]) {
				total++;
				System.out.println(a[1]+" "+a[2]+" "+a[3]+" "+"+"+" "
						+a[4]+" "+a[5]+" "+a[6]+" "+"="
						+" "+a[7]+" "+a[8]+" "+a[9]);
			}
			return;//返回之前一步
		}
		
		for (int i = 1; i < a.length; i++) {
			if (book[i] == 0) {//如果数字还在
				a[step] = i;//这个格子放下这个数字
				book[i] = 1;
				//这格放好了，下一步
				dfs(step+1);
				book[i] = 0;
			}		
		}
		return;
	} 

	public static void main(String[] args) {
		dfs(1);
		System.out.println("满足条件的式子共有:"+total/2+"个");

	}

}
