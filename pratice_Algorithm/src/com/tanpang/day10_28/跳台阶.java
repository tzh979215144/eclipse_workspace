package com.tanpang.day10_28;

import java.util.ArrayList;
public class 跳台阶{
	
    public int JumpFloor(int target) {
        int save=0;
        ArrayList<Node> aa=new ArrayList<Node>();
        for(int i=0;i<=target;i++){
            for(int j=0;j<=(target-i)/2+1;j++){
                if((i+j*2)==target){
                    Node nd=new Node(i,j);
//                    System.out.println("X为："+i+"\t"+"Y为："+j);
                    aa.add(nd);
                }
            }
        }
        for(Node nd : aa) {
        	int max=nd.x>nd.y?nd.x:nd.y;
        	int min=nd.x<nd.y?nd.x:nd.y;
        	save+=jie(nd.x+nd.y,max)/jie(min,1);
        }
        return save;
    }
    
    public long jie(int n,int n2){
        long num=1;
        while(n!=0){
        	if(n!=n2)
        		num*=n--;
        	else break;
//        	System.out.println(num+"------");
        }
//        System.out.println(num+"++++");
        return num;
    }
    class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}