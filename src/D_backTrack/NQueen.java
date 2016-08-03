package D_backTrack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
/**
 * 回溯的思想是：假设某一行为当前状态，不断检查该行所有的位置是否能放一个皇后，检索的状态有两种：
	（1）先从首位开始检查，如果不能放置，接着检查该行第二个位置，依次检查下去，直到在该行找到一个可以放置一个皇后的地方，然后保存当前状态，转到下一行重复上述方法的检索。
	（2）如果检查了该行所有的位置均不能放置一个皇后，说明上一行皇后放置的位置无法让所有的皇后找到自己合适的位置，因此就要回溯到上一行，重新检查该皇后位置后面的位置。
 * @author Administrator
 *
 */
public class NQueen {
	int mQueen;
	boolean[] m_col;
	boolean[] m_MainDiagonal;
	boolean[] m_MinorDiagonal;
	static int count;//解决方案个数
	private int[] location;//皇后在期盼的每行上的列的位置
	public NQueen(int m) {
		mQueen = m ;
		m_col = new boolean[m];
		m_MainDiagonal = new boolean[m*2];
		m_MinorDiagonal = new boolean[m*2];
		location = new int[m];
	}
	public void printLocation(){
		 
		System.out.println("以下是皇后在棋盘上的第"+count+"种摆放位置");
		String [][]a = new String[mQueen][mQueen];
		//初始化
		for(int i=0;i<mQueen;i++){
			  for (int j = 0; j < mQueen; j++) {
				a[i][j] = "-";
			  }
		}
		for(int i=0;i<mQueen;i++){
			for (int j = 0; j < mQueen; j++) {
				a[i][location[i]] = "*";
			}
		}
		for (String[] js : a) {
			for (String j : js) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
	 }
	void calcQueen(int row){
		if(row == mQueen){
			count++;//统计解决方案的个数
	    	printLocation();//完成任务，打印所有皇后的位置
	    	System.out.println("======over======");
	    	return;
		}
		for (int col = 0; col < mQueen; col++) {
			if(isCalc(row,col)){
				//找到了合适的列位置col放置皇后
				location[row] = col ;
				setStatus(row, col,true);
				calcQueen(row+1);//如果所有皇后没有摆完，递归摆放下一行的皇后
				setStatus(row, col,false);
			}
		}
		
	}
	public void setStatus(int row, int col, boolean status) {
		m_col[col] = status;
		m_MainDiagonal[row+col] = status;
		m_MinorDiagonal[row-col-1+mQueen] = status;
	}
	private boolean isCalc(int row, int col) {
		return !m_col[col] && !m_MainDiagonal[row+col] && !m_MinorDiagonal[row-col-1+mQueen];
	}
	public static void main(String[] args) {
		NQueen nq = new NQueen(8);
		nq.calcQueen(0);
//		print(nq.result);
	}
	private static void print(List<int[]> result2) {
		for (int[] is : result2) {
			for (int i : is) {
				System.out.println(i + "\t");
			}
			System.out.println();
		}
	}
}
