package com.tanpang.day10_31;

import java.util.HashMap;
import java.util.Scanner;

public class 有赞笔试1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len=str.length();
        String[] num=str.substring(1, len-1).split(",");
        len=num.length;
        HashMap<String,Integer> count=new HashMap<String,Integer>();
        for(int i = 0; i < len; i++){
        	count.put(num[i], 0);
        } 
        for(int i = 0,q=0; i < len; i++){
        	
        	q=count.get(num[i]);
        	
        	count.put(num[i], q+1);
        	if(count.get(num[i])>len/2) {
        		System.out.println(num[i]);
        		break;
        	}
        } 
    }
}