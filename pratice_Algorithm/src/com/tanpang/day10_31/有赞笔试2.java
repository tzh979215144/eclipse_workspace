package com.tanpang.day10_31;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入数组，格式为：[1,6,4,4,7]
 * 要求得到第三大的元素
 * 输出：6
 * 
 * 处理过程：1、解析输入数组的格式（输入时为字符串）
 * 								首先将字符串首位去除，用substring方法，再用split方法分割“，”得到字符串数组
 * 					2、去重复，再得到int数组：
 * 								因为set类型内部自动去重复，所以将步骤一得到的String数组遍历，同时转化为Integer，存入到hashset里
 * 								遍历完成之后得到 无重复的hashset类型对象，再调用haseset的toArray方法，返回Object数组
 * 								再遍历Object数组转存为int数组，即可得到无重复的int数组！
 * 					3、最后调用快排方法，将int数组排序
 * ！！！这里有个神奇的地方：hashset自动排序了，因为他调用了hashmap的hashcode方法，但实际上在扩容时会有小小的非排序
 * 												所以还是调用一下排序算法
 * @author tanpang
 *
 */
public class 有赞笔试2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len=str.length();
        String[] pp=str.substring(1, len-1).split(",");
        len=pp.length;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=-0;i<len;i++) {
        	set.add(Integer.parseInt(pp[i]));
        }
       Object[] bb=set.toArray();
       int [] aa=new int[bb.length];
        for(int i=0;i<bb.length;i++) {
        	aa[i]=(int)bb[i];
        }
        for(int i:aa) {
        	System.out.print(i+"\t");
        }
        System.out.println();
        quickSort(aa);
        System.out.println(aa[2]);
        int[] cc =new int[] {1,2,3,4,5};
        quickSort(cc);
        for(int i:cc) {
//        	System.out.print(i+"\t");
        }
    }
    
    /**
     * 下面是快排的方法
     * @param array
     */
    public static void quickSort(int[] array){  
        if(array != null){  
            quickSort(array, 0, array.length-1);  
        }  
    }  
      
    private static void quickSort(int[] array,int beg,int end){  
        if(beg >= end || array == null)  
            return;  
        int p = partition(array, beg, end);  
        quickSort(array, beg, p-1);  
        quickSort(array, p+1, end);  
    }  
    private static int partition(int[] array, int beg, int end) {  
        int first = array[beg];  
        int i = beg, j = end;  
        while (i < j) {  
            while (array[i] <= first && i < end) {  
                i++;  
            }  
            while (array[j] > first && j >= beg) {  
                j--;  
            }  
            if (i < j) {  
                array[i] = array[i] ^ array[j];  
                array[j] = array[i] ^ array[j];  
                array[i] = array[i] ^ array[j];  
            }  
        }  
        if (j != beg) {  
            array[j] = array[beg] ^ array[j];  
            array[beg] = array[beg] ^ array[j];  
            array[j] = array[beg] ^ array[j];  
        }  
        return j;  
    }  
}