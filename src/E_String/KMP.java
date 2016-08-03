package E_String;

import java.util.Arrays;

/**
 * KMP算法 o(m+n)
 * @author Administrator
 *
 */
public class KMP {
	public static void main(String[] args) {
		String targ = "acacaabaabcacaabc";
		String patt = "abaabcac";
		System.out.println("===============暴力匹配==============");
		int i = SimpleP(targ,patt);
		System.out.println(i);
		System.out.println("===============KMP匹配==============");
		int j = Kmp(targ,patt);
		System.out.println(j);
		KMP k = new KMP();
		String a="abcaabbabcabaa";
//		System.out.println(Arrays.toString(k.next(a)));
		System.out.println(Arrays.toString(k.getNext(a)));
	}
	
	private static int Kmp(String targ, String patt) {
		int []next = getNext(patt);
		int j=0,i=0;
		for (i = 0; i < targ.length(); i++) {
			while(patt.charAt(j)!=targ.charAt(i)&&j>0)
//				j=next[j-1];
				j=next[j];
			if(patt.charAt(j)==targ.charAt(i)) j++;
			if(j==patt.length()) return i-j + 1;
		}
		return -1 ;
		
	}
	public static int[] getNext(String b)  
	{  //abcaabbabcabaa
	    int len=b.length();  
	    int j=0;  
	    int next[]=new int[len+1];//next表示长度为i的字符串前缀和后缀的最长公共部分，从1开始  
	    next[0]=next[1]=0;  
	    for(int i=1;i<len;i++)//i表示字符串的下标，从0开始  
	    {//j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置  
	        while(j>0&&b.charAt(i)!=b.charAt(j))
	        	j=next[j];  
	        if(b.charAt(i)==b.charAt(j))
	        	j++;  
	        next[i+1]=j;  
	    }  
	    return next;  
	}  
	 public static int[] next(String patt) {
		 int length=patt.length();
         int[] a = new int[length];
         a[0] = 0;
         for(int i = 1;i<length;i++){
        	 int k = a[i-1];
        	 while(k>0&&patt.charAt(i)!=patt.charAt(k)){
        		 k=a[k-1];
        	 }
        	 if(patt.charAt(i)==patt.charAt(k))
        		 a[i] = k+1;
        	 else a[i] = 0 ;
         }
        return a;
    }

	private static int SimpleP(String targ, String patt) {
		int i=0,j=0;
		while(j<patt.length()&&i<targ.length()){
			if(patt.charAt(j)==targ.charAt(i)) {
				i++;
				j++;
			}
			else {
				i = i-j+1;
				j=0;
			}
		}
		if(j>=patt.length()) return i-j ;
		return -1 ;
	}
}
