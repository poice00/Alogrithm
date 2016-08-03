package B_dynamicPrograming;

import java.util.Arrays;

/**
 * 0-1背包问题
 * @author Administrator
 * 01背包问题具体例子：假设现有容量10kg的背包，另外有3个物品，分别为a1，a2，a3。
 * 物品a1重量为3kg，价值为4；物品a2重量为4kg，价值为5；物品a3重量为5kg，价值为6。将哪些物品放入背包可使得背包中的总价值最大？
 */
public class Knapsack01 {
	public static void main(String[] args) {
		int []weight = {3,4,5};
		int []value = {4,5,6};
		int capcity = 10 ;
		knapsack(value,weight,capcity);
	}

	private static void knapsack(int[] value, int[] weight, int capcity) {
		//状态方程：c[i][m]=max{c[i-1][m-w[i]]+vi , c[i-1][m]}
		//当前加入的物品小于上次的 则上次 否则是新的重量
		//初始化矩阵
		int row = weight.length; //3
		int col = capcity; //10
		int [][]m = new int[row+1][col+1];
//		print(m);
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(j>=weight[i-1]){
					if(m[i-1][j]<m[i-1][j-weight[i-1]] + value[i-1])
						m[i][j] = m[i-1][j-weight[i-1]] + value[i-1];
					else
						m[i][j] = m[i-1][j];
				}else
					m[i][j] = m[i-1][j];
			}
		}
		print(m);
		System.out.println("最大价值是: " + m[row][col]);
		
		int []x = new int [row];//row = 3 ;
		//求出最优解
		for (int i = row; i > 0; i--) {
			System.out.println(m[i][capcity]+"--"+m[i-1][capcity]);
			if(m[i][capcity] > m[i-1][capcity]){
                x[i-1] = 1;
                capcity = capcity - weight[i-1];
            }
		}
		print(x);
		System.out.print("选取的是：");
		for (int i=0 ;i<x.length; i++) {
			if(x[i]==1){
				System.out.print(weight[i] + "\t");
			}
		}
		System.out.println();
	}
	//方法的重写overloading print(args)
	private static void print(int[] x) {
		System.out.println(Arrays.toString(x));
	}

	public static void print(int[][] m) {
		for (int[] is : m) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
