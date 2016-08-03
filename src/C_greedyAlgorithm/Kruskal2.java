package C_greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Kruskal 最小支撑树(o(nlogn))
 * @author Administrator
 *
 *	算法思想：

	选择最小边，但保证不形成环路，直到所有点都选完
	保证不形成环路的思路是，利用一个数组group存放每个顶点的连通图标示，当所有的顶点的连通图标识都一样，才算全通路，结束
 */
public class Kruskal2 {
		
		private static int M = 10000; //此路不通
		static int MAX = Integer.MAX_VALUE;
		public static void main(String[] args) {
			List<Edge> edgesSet = new ArrayList<Edge>(); 
			int [][]data = {
					{M,6,1,5,M,M},
					{6,M,5,M,3,M},
					{1,5,M,5,6,4},
					{5,M,5,M,M,2},
					{M,3,6,M,M,6},
					{M,M,4,2,6,M}
			};
			for (int i = 0; i < data.length; i++) {
				for (int j = i; j < data.length; j++) {
					if(data[i][j]!=M){
						Edge edge = new Edge(i, j, data[i][j]);
						edgesSet.add(edge);
					}
				}
			}
			int []group = new int[data.length];
			kruskal(edgesSet,group);
		}
	    public static void kruskal(List<Edge> edgesSet, int[] group) {
	    	Collections.sort(edgesSet);
	    	int id = 1 ;
	    	for (Edge edge : edgesSet) {
	    		int start = edge.u;
	    		int end = edge.v;
	    		if(group[start]!= 0 && group[end] != 0 &&group[start] == group[end] ) continue;
	    		System.out.println((start+1) + " ---> " + (end+1) + " " + edge.weight);
	    		if(group[start] == 0 && group[end] == 0){
	                group[start] = id;
	                group[end] = id;
	                id++;
	            }else if(group[start] > 0 && group[end] > 0) {
	                int tmp = group[end];
	                for(int m = 0; m < group.length; m++){
	                    if(group[m] == tmp){
	                        group[m] = group[start];
	                    }
	                }
	            }
	            else{
	                if(group[start] == 0){
	                    group[start] = group[end];
	                }
	                else{
	                    group[end] = group[start];
	                }
	            }
//	    		System.out.println(Arrays.toString(group));
			}
	    }

}
