package hadoop_7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 围湖造田：找到一个矩阵中被x包围的区域
 *   x x x x    	x x x x 
 *   x o o x		x x x x 
 *   x x o x  -->   x x x x
 *   x o x x        x o x o
 * @author ssy
 *
 */
public class SurroundedRegion {
	public static void main(String[] args) {
		int N = 4 ;
		String [][]land = new String[][]{
				{"x","x","x","x"},
				{"x","o","o","x"},
				{"x","x","o","x"},
				{"x","o","x","x"},
		};
		print(land,N);
		FillLake(land,N);
		print(land,N);
	}

	private static void FillLake(String[][] land, int N) {
		//从边缘开始 获得海洋区域
		for (int i = 0; i < N; i++) {
			if(land[i][0].equals("o"))
				Ocean(land,N,i,0);
			if(land[i][N-1].equals("o"))
				Ocean(land,N,i,N-1);
		}
		for (int i = 1; i < N-1; i++) {
			if(land[0][i].equals("o"))
				Ocean(land,N,0,i);
			if(land[N-1][i].equals("o"))
				Ocean(land,N,N-1,i);
		}
		//恢复海洋 填湖
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(land[i][j].equals("y")) land[i][j]="o";
				else if (land[i][j].equals("o")) land[i][j]="x";
			}
		}
	}

	private static void Ocean(String[][] land, int N, int i, int j) {
		land[i][j] = "y" ;
		Pair pair = new Pair(i,j); 
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(pair);
		int []iDirect = {-1,1,0,0};
		int []jDirect = {0,0,-1,1};
		while(!q.isEmpty()){
			Pair p = q.poll();
			i = p.first;
			j = p.second;
			for (int k = 0; k < 4; k++) {
				int icur = i + iDirect[k] ;
				int jcur = j + jDirect[k] ;
				if(isOcean(land,N,icur,jcur)){
					q.add(new Pair(icur,jcur));
					land[icur][jcur] = "y" ;
				}
			}
		}
	}

	private static boolean isOcean(String[][] land, int N, int i, int j) {
		if(i<0 || j<0||i>=N||j>=N) return false ;
		return land[i][j].equals("o");
	}

	private static void print(String[][] land, int n) {
		for (String[] strings : land) {
			for (String string : strings) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
