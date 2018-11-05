package com.tanpang.day01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		int sava=2;//a1在首尾两种 
		 Stack<Integer> stackData;
		 Stack<Integer> stackMin;
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		String[] str = new String[num];
		String[] a = new String[num];
		sc.nextLine(); // 读掉数值后面的换行符
		for(int n=0;n<num;n++) {
			str[n]=sc.nextLine();
		}
		for(int i =0;i<num;i++) {
			//System.out.println(i);
		System.out.println(str[i]);
		}
		
		//开始处理
		//对a1的赋值为b[i]，从第二位到倒数第二
		for(int i=1;i<num;i++) {
			a[0]=str[i];
			//每一次a【0】不同的值都是一种情况
			for(int j=1,L=i,R=i,flag=1;j<num;j++)
			{
				
				a[j]=str[L-1];
				System.out.println("---"+a[j]);
				if(hello(L-1,num)==1) {
					sava++;
					L++;
					flag=0;
				}
				System.out.println("sava!"+sava);
				L--;
				if(R==num-1) {
					break;
				}
				System.out.println("+++"+R+"次+"+str[R+1]);
				a[j]=str[R+1];
				if(hello(R+1,num)==1) {
					sava++;
					R--;
					System.out.println("sava!!"+sava);
					if(flag==0)
					break;
				}
				System.out.println("sava!!"+sava+"-------------------------------------------");
				R++;
				
				
			}
		}
		System.out.println(sava);
	}
	
	public static int  hello(int x,int num) {
		if(x==0||x==(num-1)) {
			//sava++;
			return 1;
		}else return 0;
	}
}
