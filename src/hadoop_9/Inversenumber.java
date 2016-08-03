package hadoop_9;

import java.util.Arrays;

public class Inversenumber {
	static int count = 0 ;
	public static void main(String[] args) {
		
		int []a =  {3,56,4,45,7,8,1};
		System.out.println(Arrays.toString(a));
		mergeSort(0,a.length-1,a);
		System.out.println(Arrays.toString(a));
		System.out.println(count);
	}

	private static void mergeSort(int low, int high, int[] a) {
		if(low>=high) return ;
		int mid = (low+high)/2 ;
		mergeSort(low, mid, a);
		mergeSort(mid+1, high, a);
		merge(low,mid,high,a);
	}

	private static void merge(int low, int mid, int high, int[] a) {
		int tmp[] = new int[100];
		int i = low;
		int j = mid+1;
		int size = 0 ;
		while(i<=mid&&j<=high){
			if(a[i]<a[j])
				tmp[size++] = a[i++];
			else{
//				count += ( mid-i+1 );
				count += ( j-mid );
				tmp[size++] = a[j++];
			}
		}
		while(i<=mid){
			tmp[size++] = a[i++];
		}
		while(j<=high){
			tmp[size++] = a[j++];
		}
		for (int k = 0; k < size; k++) {
			a[k+low] = tmp[k];
		}
	}
}
