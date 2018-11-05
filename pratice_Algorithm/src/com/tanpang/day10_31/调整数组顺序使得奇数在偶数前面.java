package com.tanpang.day10_31;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *思路:
 *			首先遍历数组，奇数的存到数组A，偶数的存到数组B
 *			再把数组AB合并
 *牛客网看了个思路：如果两个相邻的是一奇数一偶数，则交换
 * @author tanpang
 *
 */
public class 调整数组顺序使得奇数在偶数前面 {
	public static void main(String[] args) {
		int[] cc=new int[]{1,6,2,4,3,3,5,8};
		reOrderArray(cc);
		for(int c:cc)
		System.out.println(c);
	}
    public static void reOrderArray(int [] array) {
        int len=array.length;
        int a=0,b=0;
        int[] aa=new int[len];
        int[] bb=new int[len];
        for(int i=0;i<len;i++) {
        	if(array[i]%2==0) {
        		bb[b++]=array[i];
        	}else {
        		aa[a++]=array[i];
        	}
        }
        System.out.println(a+"aa");
        for(int i=0;i<a;i++) {
        	array[i]=aa[i];
//        	System.out.print(aa[i]+"**");
        }
        for(int i=a,j=0;i<len;i++,j++) {
        	array[i]=bb[j];
        }
    }

}
