package datastruts;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		String x = "abcdef";
		String xx = reverse(x);
		System.out.println(xx);
	}

	private static String reverse(String x) {
		char [] arr = x.toCharArray();
		int begin = 0 ;
		int end = arr.length -1 ;
		while(begin<end){
//			swap(xx[a],xx[b]);
//			a++;
//			b--;
			swap(arr, begin, end);  
            begin++;  
            end--;
		}
			
		return new String(arr);
	}

	public static void swap(char[] arr, int begin, int end) {
		char temp = arr[begin];  
		arr[begin] = arr[end];  
		arr[end] = temp;
	}

	private static void swap(char a, char b) {
		char tmp = a ;
		a = b ;
		b = tmp;
	}
	
}
