package C_greedyAlgorithm;

import java.util.Arrays;
import java.util.Stack;

/**
 * Dijkstra 单元最短路径
 * @author Administrator
 *
 */
public class Dijkstra {
	private static int M = 10000; //此路不通
	public static void main(String[] args) {
		 int[][] weight2 = { 
			        {0,10,M,30,100}, 
			        {M,0,50,M,M}, 
			        {M,M,0,M,10}, 
			        {M,M,20,0,60}, 
			        {M,M,M,M,0} 
			    };
		 int start = 0 ;
		 int []result = dijkstra(start,weight2);
		 for(int i = 0;i < result.length;i++) 
		       System.out.println("从"+start+"出发到"+i+"的最短距离为："+result[i]); 
	}

	private static int[] dijkstra(int start, int[][] tar) {
		int len = tar.length;
		int []result = new int[len]; //存放最短路径的长度
		int []prev = new int[len]; //存放最短路径的过程
		boolean[] visited = new boolean[len];   //标记当前该顶点的最短路径是否已经求出,true表示已求出 
		//初始化
		for(int i=0;i<len;i++) {
			result[i] = tar[start][i];
			if(result[i]==M) prev[i] = M ;
			else prev[i] = start;
		}
		visited[start] = true;
		//贪心选择最短的路径:得到下标和最短路径的值
		for (int count = 1; count < len; count++) {
			int k = 0 ;
			int min = Integer.MAX_VALUE;
			for (int i = 1; i < len; i++) {
				if(visited[i] == false && result[i] <min){
					min = result[i];
					k = i ;
				}
			}
			//将得到的点标记为false，并且到start的最短路径就是min
			visited[k] = true ;
//			result[k] = min;
			//动态规划部分，选取路径最小的路线
			for (int j = 0; j < len; j++) {
				if(visited[j] == false  &&result[j] > result[k] + tar[k][j]){
					result[j] = result[k] + tar[k][j];
					prev[j] = k ;
				}
			}
		}
		System.out.println(Arrays.toString(prev));
		 for(int i = 0; i < len; i++) {
			 System.out.println("从"+start+"出发到"+i+"的最短路径为："+start + getPath(prev,i,start) );
		 }
		 System.out.println("====================================="); 
		return result ;
	}

	private static String getPath(int[] prev, int i,int start) {
		//[0, 0, 3, 0, 2]
		// 0  1  2  3  4 
		Stack<Integer> s= new Stack<>();
		String result = "";
		if(i==start) return "-->" + i;
		while(i!=start){
			s.push(i);
			i = prev[i];
		}
		//s.push(i);
		while(!s.empty()){
			result = result + "-->" + s.pop();
		}
		return result;
	}
}
