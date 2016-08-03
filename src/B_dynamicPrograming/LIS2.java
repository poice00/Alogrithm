package B_dynamicPrograming;

import java.util.Arrays;

/**
 * LIS (O(nlogn))
 * @author Administrator
 *
 */
public class LIS2 {
	public static int search(int x,int []a ,int left,int right){
		while(left<=right){
			int mid = (left+right) / 2 ;
			if(x == a[mid]) return mid ;
			if(x > a[mid]) left = mid + 1 ;
			else right = mid -1 ;
		}
		return -1 ;
	}
	public static int LIS(int[] a, int n, int[] d)  
	{  
	    int left, right, mid, len = 1;  
	    d[0] = a[1]; //为了和上面的一致，我们从1开始计数吧:)  
	    for(int i = 2; i <= n; ++i){  
	        left = 0;
	        right = len;  
	        while(left <= right){  
	            mid = (left + right) / 2;  
	            if(d[mid] < a[i]) left = mid + 1; //二分查找d[i]的插入位置  
	            else right = mid - 1;  
	        }  
	        d[left] = a[i]; //插入  
	        if(left > len) len++; //d[i]比现有的所有数字都大，所以left 才会大于 len。  
	    }  
	    System.out.println(Arrays.toString(d));
	    return len;  
	}  
	public static void main(String[] args) {
		int a[] ={1, -1, 2, -3, 4, -5, 6, -7};     //a[i] 原始数据  
		int d[] = new int[a.length];       //d[i] 长度为i的递增子序列的最小值  
		LIS(a, a.length-1, d);
	}
}
