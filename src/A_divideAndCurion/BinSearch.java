package A_divideAndCurion;
/**
 * 二分查找
 * @author Administrator
 *
 */
public class BinSearch {
	public static int search(int []a ,int x){
		int right = a.length;
		int left = 0 ;
		while(left<=right){
			int mid = (left+right) / 2 ;
			if(x == a[mid]) return mid ;
			if(x > a[mid]) left = mid + 1 ;
			else right = mid -1 ;
		}
		return -1 ;
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,10};
		System.out.println(search(a, 10));
	}
}
