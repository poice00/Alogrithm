package hadoop_7;
/**
 * 马踏棋盘问题
 * --深度优先搜索--
 * @author ssy
 *
 */
public class Mtqp {
	static int m = 8;
	static int n = 8;
	static int iHorse[] = {-2,-2,-1,-1,+1,+1,+2,+2};
	static int jHorse[] = {-1,+1,-2,+2,-2,+2,-1,+1};
	public static void main(String[] args) {
		int [][]chess = new int[8][8] ;
		chess[0][0] = 1 ;
		Jump(chess,0,0,1);
		print(chess);
	}

	private static boolean Jump(int[][] chess, int i, int j, int step) {
		if(step == m*n){
			return true;
		}
		for (int k = 0; k < 8; k++) {
			int iCur = i + iHorse[k];
			int jCur = j + jHorse[k];
			if(canJump(chess,iCur,jCur)){
				chess[iCur][jCur] = step + 1 ;
				if(Jump(chess,iCur,jCur,step+1)){
					return true;
				}
				chess[iCur][jCur] = 0 ;
			}
		}
		return false;
	}

	private static boolean canJump(int[][] chess, int i, int j) {
		if(i<0 || j<0 || i>=m ||j>=n) return false;
		return chess[i][j] == 0;
	}

	private static void print(int[][] chess) {
		for (int[] is : chess) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
