package hadoop_1;

import java.util.Arrays;

public class TwoMax {
	public static void main(String[] args) {
		int []a={1,3,4,6,7,9,11,23,42,35};
		getMax(2,a);
	}

	private static void getMax(int i, int[] a) {
		
		int []x = new int[i];
		x[0] = 0 ;//最大
		x[1] = Integer.MIN_VALUE ;//第二大
		for (int j : a) {
			if(j>x[0]){
				x[1] = x[0] ;
				x[0] = j ;
			}else{
				if(j>x[1])
					x[1] = j ;
			}
		}
		System.out.println(Arrays.toString(x));
	}
}
