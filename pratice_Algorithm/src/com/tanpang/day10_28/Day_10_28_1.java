package com.tanpang.day10_28;
import java.util.ArrayList;
import java.util.Stack;
public class Day_10_28_1 {
	public static void main(String[] args) {
		ListNode l=new ListNode(10);
		ListNode l2=new ListNode(20);
		ListNode l3=new ListNode(30);
		l.next=l2;
		l2.next=l3;
		ListNode l4=new ListNode();
		System.out.println(printListFromTailToHead(l4));
	}
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> sk=new Stack<Integer>();
    	ArrayList<Integer> ls=new ArrayList<Integer>();
    	while(listNode!=null){
            sk.push(listNode.val);
            listNode=listNode.next;
        }
            
    	while(!sk.isEmpty()){
    	   ls.add(sk.pop());
       }
        System.out.println(ls);	
        return ls;
        
    }
}

  class ListNode {
       int val;
       ListNode next = null;
       ListNode(){
    	   
       }
       ListNode(int val) {
           this.val = val;
       }   
   }
