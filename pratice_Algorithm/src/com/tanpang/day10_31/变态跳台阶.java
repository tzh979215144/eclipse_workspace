package com.tanpang.day10_31;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *	这里是利用了递归
 * @author tanpang
 *
 */
public class 变态跳台阶 {
	public static void main(String[] args) {
		for(int i=1;i<20;i++) {
//			System.out.println("****************");
			System.out.println(JumpFloorII(i));
		}
	}
	public static int JumpFloorII(int target) {
        int n=target;
        if(n==0){return 0;}
        int[] ss=new int[n+1];
        ss[0]=1;
        ss[1]=1;
        for(int i=2;i<=n;i++) {
        	ss[i]=0;
        	for(int j=0;j<i;j++) {
        		ss[i]+=ss[j];
//        		System.out.println("第"+j+"次"+ss[j]+"----");
        	}
        }
        return ss[n];
    }

}
