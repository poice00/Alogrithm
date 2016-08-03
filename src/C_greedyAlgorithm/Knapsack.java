package C_greedyAlgorithm;

import java.util.Arrays;

import A_divideAndCurion.QuickSort;

/**
 * 背包问题(最优装载问题) 区别于01背包
 * @author Administrator
 *
 */
public class Knapsack {
	public static void main(String[] args) {
		float M = 50;//背包所能容纳的重量  
	    //这里给定的物品按单位价值减序排序  
	    float weight[] = {20,30,10};//下标从1开始  
	    float value[] = {100,120,60};
	    greedy(weight,value,M);
	}
	//3 种贪心选择策略 1.最大重量 2.最小重量 3.单位重量
	private static void greedy(float[] weight, float[] value, float m) {
		int len = weight.length ;
		float []xx = new float[len];
		float []selectWeight = new float[len];
		boolean []visted = new boolean[len];
		float sum = 0 ;
		int index=0 ;
		for (int i = 0; i < xx.length; i++) {
			float dmin = Float.MIN_VALUE ;
			int k = -1 ;
			//贪心选择单位质量最小的
			for (int j = 0; j < len; j++) {
				xx[j] = value[j] / weight[j];
				if(visted[j]==false && xx[j]>dmin){
					dmin = xx[j];
					k= j;
				}
			}
			System.out.println("k: " + k);
			visted[k] = true;
			System.out.println("选择了： " + weight[k]);
			sum += weight[k];
			selectWeight[index] = weight[k];
			if(sum>m){
				sum = sum-weight[k];
				float s = m - sum;
				selectWeight[index] = s ;
				break;
			}
			index ++ ;
		}
		System.out.println(Arrays.toString(selectWeight));
	}
}
