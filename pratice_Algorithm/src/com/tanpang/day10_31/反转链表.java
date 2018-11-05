package com.tanpang.day10_31;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 思路：两个新建节点保存交换的节点和他下一个节点的信息，遍历节点作交换
 * @author tanpang
 *
 */
public class 反转链表{
	public static void main(String[] args) {
		ListNode aa=new ListNode(1);
		ListNode bb=new ListNode(2);
		ListNode cc=new ListNode(3);
		aa.next=bb;
		bb.next=cc;
		ListNode dd=ReverseList(aa);
		System.out.println(dd.val+""+dd.next.val);
	}
    public static ListNode ReverseList(ListNode head) {
    		ListNode la=null,lb=null,lc=null;
    		la=head;
    		if(la==null) {return null;}
    		lb=head.next;
    		lc=lb;
    		if(lb==null) {return head;}
    		if(lc.next==null) {return head.next;}
    		la.next =null;
    		while(lc.next!=null) {
    			lc=lb.next;
    			lb.next=la;
    			la=lb;
    			lb=lc;
    		}
    		lb.next=la;
    		return lb;
    }
}