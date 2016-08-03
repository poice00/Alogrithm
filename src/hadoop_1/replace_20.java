package hadoop_1;

import java.util.Arrays;

public class replace_20 {
	public static void main(String[] args) {
		String s = "we are best" ;
//		System.out.println(s);
//		s = s.replace(" ", "%20");
//		s = change(s,"%20");
//		System.out.println(s);
		int i = 5 ;
		int x = i --;
//		int x = -- i;
//		System.out.println(i);
//		System.out.println(x);
		String string = "11124523";
		System.out.println(parseToInt(string));
	}

	private static Object parseToInt(String string) {
		if(string == null ||("").equals(string)){
			System.out.println("input error!");
		}
		int i = 0 ;
		int num = 0 ;
		for (int j = 0; j < string.length(); j++) {
			char c = string.charAt(i);
			if(c>'9' || c < '0') {
				return "input error!";
			}
			num = num * 10 + (c-'0');
			i ++;
		}
		return num ;
	}

	private static String change(String s, String string) {
		int numberOfBlank = 0 ;
		int len = s.length();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' '){
				++ numberOfBlank;
			}
		}
		int newLength = len + numberOfBlank * 2 ;
		String []resu = new String[newLength];
		for (int i = 0; i < s.length(); i++) {
			resu[i] =String.valueOf(s.charAt(i));
		}
		int p1 = len-1 ;
		int p2 = newLength-1; 
		while(p1>=0 && p2 > p1){
			if(s.charAt(p1)==' '){
				resu[p2--] = "0";
				resu[p2--] = "2";
				resu[p2--] = "%";
			}else{
				resu[p2--] = String.valueOf(s.charAt(p1));
			}
			-- p1;
		}
		return Arrays.toString(resu);
	}
}
