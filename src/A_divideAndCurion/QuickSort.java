package A_divideAndCurion;

public class QuickSort {
	public static void quickSort(float []a,int low,int high){
		if(low<high){
			int privet = partition(a,low,high);
			quickSort(a, low, privet-1);
			quickSort(a, privet+1, high);
		}
	}
	public static void quickSort(int []a,int low,int high){
		if(low<high){
			int privet = partition(a,low,high);
			quickSort(a, low, privet-1);
			quickSort(a, privet+1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int tmp = a[low];
		while(low<high){
			while(low<high&&a[high]>tmp) high--;
			a[low] =a[high];
			while(low<high&&a[low]<tmp) low++;
			a[high] =a[low];
		}
		a[low] = tmp ;
		return low;
	}
	private static int partition(float[] a, int low, int high) {
		float tmp = a[low];
		while(low<high){
			while(low<high&&a[high]>tmp) high--;
			a[low] =a[high];
			while(low<high&&a[low]<tmp) low++;
			a[high] =a[low];
		}
		a[low] = tmp ;
		return low;
	}
	public static void main(String[] args) {
		int []a = {1,2,3,4,6,5,9,7};
		quickSort(a, 0, a.length-1);
		for (int i : a) {
			System.out.print(i+"\t");
		}
	}
}
