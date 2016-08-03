package E_String;

import java.util.Arrays;

/*
 * 全排列
 */
public class Quanpailie {
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		permutation(a,a.length,0);
	}

	private static void permutation(int[] a, int length, int n) {
		if(n==length-1){
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = n; i < length; i++) {
			swap(i,n,a);
			permutation(a, length, n+1);
			swap(i,n,a);
		}
	}


	private static void swap(int i, int n,int []a) {
		int tmp = a[i] ;
		a[i] = a[n];
		a[n] = tmp;
	}
}
