package hadoop_7;

public class Catalan {
	/**
	 * 卡特兰数
	 * 1.给定n个数字 求出栈的顺序
	 * 2.n个节点形成的二叉树的个数
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 19;
		int []catalan = new int[n+1];
		System.out.println(getcatalan(catalan,n));
	}

	private static int getcatalan(int []catalan,int n) {
		catalan[0] = 1;
		catalan[1] = 1;
		for (int i = 2; i <= n; i++) {
			int c = 0 ;
			for (int j = 0; j < i; j++) {
				c += catalan[j] * catalan[i-j-1];
			}
			catalan[i] = c ;
		}
		return catalan[n];
	}
}
