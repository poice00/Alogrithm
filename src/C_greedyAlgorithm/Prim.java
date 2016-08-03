package C_greedyAlgorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * Prim 最小生成树
 * @author Administrator
 *
 */
public class Prim {
	private static int M = 10000; //此路不通
	public static void main(String[] args) {
		int [][]data = {
				{M,6,1,5,M,M},
				{6,M,5,M,3,M},
				{1,5,M,5,6,4},
				{5,M,5,M,M,2},
				{M,3,6,M,M,6},
				{M,M,4,2,6,M}
		};
		 int start = 0 ;
		 prim(start,data);
	}

	private static void prim(int start, int[][] tar) {
		int len = tar.length;
		int []dist = new int[len]; //保存每次距离已标记顶点的最短距离
		int []path = new int[len]; //
		boolean[] visited = new boolean[len];   //标记当前该顶点的最短路径是否已经求出,true表示已求出 
		//初始化
		for(int i=0;i<len;i++) {
			dist[i] = tar[start][i];
			path[i] = 1 ;
		}
		visited[start] = true;
		System.out.println(start+1 + "." + 0);
		//贪心选择最短的路径:得到下标和最短路径的值
		for (int count = 1; count < len; count++) {
			System.out.println(Arrays.toString(dist));
			int k = 0 ;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < len; i++) {
				if(visited[i] == false && dist[i] <min){
					min = dist[i];
					k = i ;
				}
			}
			System.out.println((k+1) + "." + dist[k]);
			//将得到的点标记为false，并且到start的最短路径就是min
			visited[k] = true ;
//			result[k] = min;
			//动态规划部分，选取路径最小的路线
			for (int j = 0; j < len; j++) {
				if(visited[j] == false  &&dist[j] > tar[k][j]){
					dist[j] = tar[k][j];
					path[j] = k ;
				}
			}
		}
	}

}
