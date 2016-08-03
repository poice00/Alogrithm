package A_divideAndCurion;
/**
 * 整数划分问题
 * @author Administrator
 *
 */

public class Digitdivide {
	public static int q(int n,int m){
		if(n<1||m<1) return 0;
		if(n==1||m==1) return 1;
		if(n<m) return q(n,n);
		if(n==m) return 1 + q(n,m-1);
		return q(n,m-1) + q(n-m,m);
	}
	public static void main(String[] args) {
		System.out.println(q(6,6));
	}
}
