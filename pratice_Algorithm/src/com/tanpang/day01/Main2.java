package com.tanpang.day01;

import java.util.Scanner;
/**
 * 显示2到n之间的质数，包括2和n
 * 如果没有则输出0
 * 输出格式为2,3,5
 * @author tanpang
 *
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag=true;
        boolean flag2=false;
        for(int i = 2; i <=n; i++){
            flag=true;
            for(int j = 2; j <(int) Math.sqrt(i)+1; j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag==true){
            	if(i!=2){
                    System.out.print(",");
                }
            	flag2=true;
                System.out.print(i);
            }
        } 
        if(flag2==false) {
        	System.out.print(0);
        }
    }
}