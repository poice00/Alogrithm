package E_String;
/**
 * 字符串的循环移位
 * @author ssy
 *
 */
public class Xunhuanyiwei {
	public static void main(String[] args) {
		String s = "abcdef";
		move(s,s.length(),2);
	}

	private static void move(String s, int len ,int m) {
		// TODO Auto-generated method stub
		m %= len;
		System.out.println(reverseString(s,0,m-1));
		System.out.println(reverseString(s,m,len-1));
		System.out.println(reverseString(s,0,len-1));
		System.out.println("--: " + s);
		
		System.out.println(reverseString(s,0,len-1));
		System.out.println(reverseString(s,0,m-1));
		System.out.println(reverseString(s,m,len-1));
		System.out.println("--: " + s);
	}


	private static String reverseString(String s, int from, int to) {
		char []ss = s.toCharArray();
		while(from<to){
			char c = ss[from];
			ss[from++] = ss[to];
//			from++;
			ss[to--] = c ;
//			to--;
		}
		return new String(ss);
	}
}
