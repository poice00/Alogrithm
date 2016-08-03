package B_dynamicPrograming;

import java.util.Arrays;

/**
 * 找硬币问题 
 * 给定制定面值的硬币 ，并给出一个值，要求求出硬币综合为这个值需要的最少的硬币的个数，并具体的方案
 * @author Administrator
 *
 */
public class Coins {
	public static void main(String[] args) {

		int x = 1100007;
		int []coins = {1,3,5,2};
		dpcoins(x,coins);
	}

	private static void dpcoins(int x, int[] coins) {
		int len = coins.length;
		int []m = new int[x+1];
		int[] solu = new int[x]; //记录最后一个需要的硬币
		int min = 0 ; //记录需要的硬币数量
		for (int i = 1; i <= x; i++) {
			m[i] = Integer.MAX_VALUE ; //当前最小少需要的硬币数量
			for (int j =0; j <len; j++) {
				 if(coins[j]<=i && m[i]>m[i-coins[j]]+1){  
					 	m[i]=m[i-coins[j]]+1;  
					 	solu[i-1]=coins[j]; //
				 }  
			}
			min = m[i];
		}
//		System.out.println(Arrays.toString(solu));
		 for(int i=x-1;i>=0;){  
            System.out.print(solu[i]+" ");  
            i=i-solu[i];  
        }  
		 System.out.println();
		System.out.println("需要的硬币 ：" + min + "个");
	}
	
}
