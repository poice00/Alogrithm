package C_greedyAlgorithm;

import java.util.Arrays;

/**
 * Kruskal 最小支撑树(o(nlogn))
 * @author Administrator
 *
 *	算法思想：

	选择最小边，但保证不形成环路，直到所有点都选完
	保证不形成环路的思路是，利用一个数组group存放每个顶点的连通图标示，当所有的顶点的连通图标识都一样，才算全通路，结束
 */
public class Kruskal {
		
		private static int M = 10000; //此路不通
		static int MAX = Integer.MAX_VALUE;
		public static void main(String[] args) {
			int [][]data = {
					{M,6,1,5,M,M},
					{6,M,5,M,3,M},
					{1,5,M,5,6,4},
					{5,M,5,M,M,2},
					{M,3,6,M,M,6},
					{M,M,4,2,6,M}
			};
			
			kruskal(data);
		}
	    public static void kruskal(int[][] data) {
	        int len = data.length;
	        int[] group = new int[len];//存放对应顶点所在连通图标识
	        int sum = 0, n1 = 0, n2 = 0;//sum 路径的长度
	        boolean finished = false;
	        int groupNum = 1;
	        
	        while(!finished) {
	            int min = Integer.MAX_VALUE;
	            //找出所有边中最小值
	            for(int i = 0; i < len; i++) {
	                for(int j = i+1; j < len; j++) {
	                    if(data[i][j] > 0 && data[i][j] < min){
	                        //如果group相同，则表示处理过，不相同或都为0都表示没处理过
	                        if (group[i] != group[j] || (group[i] == 0 && group[j] == 0)) {
	                            min = data[i][j];
	                            n1 = i;
	                            n2 = j;    
	                        }                                            
	                    }
	                }
	            }
	            
	            if(min == Integer.MAX_VALUE){
	                continue;
	            }
	            
//	            System.out.println(n1 + " ---> " + n2 + " " + min);
	            System.out.println((n1+1) + " ---> " + (n2+1) + " " + min);
	            sum += min;
	            //找到了最小值，设置连通标记
	            if(group[n1] == 0 && group[n2] == 0){
	                group[n1] = groupNum;
	                group[n2] = groupNum;
	                groupNum++;
	            }
	            else if(group[n1] > 0 && group[n2] > 0) {
	                int tmp = group[n2];
	                for(int m = 0; m < group.length; m++){
	                    if(group[m] == tmp){
	                        group[m] = group[n1];
	                    }
	                }
	            }
	            else{
	                if(group[n1] == 0){
	                    group[n1] = group[n2];
	                }
	                else{
	                    group[n2] = group[n1];
	                }
	            }
	            System.out.println(Arrays.toString(group));
	            for(int i = 0; i < group.length; i++) {
	                if(group[i] != group[0]){
	                    finished = false;
	                    break;
	                }
	                else{
	                    finished = true;
	                }
	            }
	            
	            if(finished) {
	                break;
	            }
	        }
	        System.out.println(" sum:"+sum);
	        
	    }

}
