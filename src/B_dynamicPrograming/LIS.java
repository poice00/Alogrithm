package B_dynamicPrograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * LIS : 最长递增子序列
 * @author Administrator
 *
 */

public class LIS
{
    public static void main(String[] args)
    {
    	int a[] ={1, 3, 2, -3, 4, -5, 6, -7};
    	System.out.println("============O(n^2)=================");
        find1(a);
        System.out.println("============O(nlogn)=================");
        lis1(a);
    }
    

    public static  void lis1(int [] L)
    {
        int n = L.length;
        float[] B = new float[n+1];//数组B；
        B[0]=-10000;//把B[0]设为最小，假设任何输入都大于-10000；
        B[1]=L[0];//初始时，最大递增子序列长度为1的最末元素为a1
        int Len = 1;//Len为当前最大递增子序列长度，初始化为1；
        int p,r,m;//p,r,m分别为二分查找的上界，下界和中点；
        for(int i = 1;i<n;i++)
        {
            p=0;r=Len;
            while(p<=r)//二分查找最末元素小于ai+1的长度最大的最大递增子序列；
            {
               m = (p+r)/2;
               if(B[m]<L[i]) p = m+1;
               else r = m-1;
            }
            B[p] = L[i];//将长度为p的最大递增子序列的当前最末元素置为ai+1;
            if(p>Len) Len++;//更新当前最大递增子序列长度；
        }
        System.out.println(Len);
        System.out.println(Arrays.toString(B));
    }
    // [1, -1, 2, -3, 4, -5, 6, -7]
    // [1, 1, 2, 1, 3, 1, 4, 1]
    // 时间复杂度:O(N*N)
    public static void find1(int[] a)
    {
        int length = a.length;
        int[] list = new int[length];// 存储第i个元素之前的最长递增序列值
//        int[] x = new int[length];// 存储第i个元素之前的最长递增序列值
//        List<Integer> result = new ArrayList<Integer>(); // 存储最长递增序列
        //用大白话解释就是，想要求d(i)，就把i前面的各个子序列中， 最后一个数不大于A[i]的序列长度加1，然后取出最大的长度即为d(i)。
        //当然了，有可能i前面的各个子序列中最后一个数都大于A[i]，那么d(i)=1， 即它自身成为一个长度为1的子序列。
        int len = 1 ;
        for (int i = 0; i < length; i++)// *
        {
            list[i] = 1;//*
            for (int j = 0; j < i; j++)//*
            {
                if (a[j] <= a[i] && list[j] + 1 > list[i])//* 找出在i位之前最大的list[j+1] 然后加1赋值给第i为
                {
                    list[i] = list[j] + 1;//*
//                    if (result.isEmpty()){
//                        result.add(list[j]);
//                        x[j] = 1 ;
//                    }
//                    if (!result.contains(list[i]))
//                    {
//                        result.add(list[i]);
//                        x[i] = 1 ;
//                    }
                }
                if(list[i]>len) len = list[i];
            }
        }
        System.out.println("第i个元素时最长递增序列：" + Arrays.toString(list));
       /* // 寻找list中最大值
        int max = list[0];
        for (int i = 0; i < length; i++)
        {
            if (list[i] > max)
            {
                max = list[i];
            }
        }*/
        System.out.println("最长递增序列长度：" + len);
//        for (int i = 0; i < x.length; i++) {
//			if(x[i]==1) System.out.print(a[i]); 
//		}
        System.out.println();
    }
}