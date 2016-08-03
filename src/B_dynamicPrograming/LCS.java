package B_dynamicPrograming;

import sun.nio.cs.ext.TIS_620;

/**
 * LCS : Longest Common Subsequence 最长公共子序列
 * @author Administrator
 *
 */
public class LCS {
	static int [][] len;
	static int [][] dir;
	public static void LCS_length(char []x,char []y){
		int m = x.length ;
		int n = y.length  ;
		len = new int[m+1][n+1];
		dir = new int[m+1][n+1];
		for (int i = 1; i < m; i++) {
			len[i][0] = 0 ;
			dir[i][0] = 0 ;
		}
		for (int i = 1; i < n; i++) {
			len[0][i] = 0 ;
			dir[0][i] = 0 ;
		}
		for (int i = 1; i <= m; i++) {//*
			for (int j = 1; j <= n; j++) {//*
				if(x[i-1]==y[j-1]){//
					len[i][j] = len[i-1][j-1] + 1 ;//*
					dir[i][j] = 1 ;//左上
				}
				else if(len[i-1][j]>=len[i][j-1]) {//*
						len[i][j] = len[i-1][j];//*
						dir[i][j] = 2 ;//上
				}
				else{
						len[i][j] = len[i][j-1];//*
						dir[i][j] = 3 ;//下
				}
			}
		}
	}
	public static void main(String[] args) {
		char[] x = {'A','B','C','B','D','A','B'};
		char[] y = {'B','D','C','A','B','A'};
		LCS_length(x,y);
		for (int[] string : len) {
			for (int i : string) {
				System.out.print(i);
			}
			System.out.println();
		}
//		LCS(dir,x,x.length,y.length);
		LCS(dir,y,x.length,y.length);
		System.out.println();
		System.out.println(len[x.length][y.length]);
	}
	private static void LCS(int[][] dir, char[] x, int i, int j) {
		if(i==0||j==0)return ;
		if(dir[i][j]==1){
			LCS(dir, x, i-1, j-1);
//			System.out.print(x[i-1]);
			System.out.print(x[j-1]);
		}else if (dir[i][j]==2){
			LCS(dir, x, i-1, j);
		}else
			LCS(dir, x, i, j-1);
	}
}
