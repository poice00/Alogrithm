package datastruts;

import java.util.Arrays;

public class valueChage {
	public static void main(String[] args) {
		String a = "a";
		int b = 3;
		StringBuilder sb = new StringBuilder("sb");
		int []c = {1,2,3};
		change(a);
		change(b);
		change(sb);
		change(c);
		System.out.println(a);
		System.out.println(b);
		System.out.println(sb);
		System.out.println(Arrays.toString(c));
	
	}
	private static void change(int[] c) {
		c[0] = 0 ;
	}
	private static void change(StringBuilder sb) {
		sb = sb.append("aa");
	}
	private static void change(int b) {
		b = 4 ;
		
	}
	private static void change(String a) {
		a += "bbb";
	}
}
