package com.tanpang.day10_31;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表中倒数第_k_个节点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        
    	if(head==null) {
    		return head;
    	}
        ListNode th=head;
    	int len=0;
    	while(th!=null) {
    			th=th.next;
    			len++;
    	}
        if(k>len){
            return null;
        }
    k=len-k;
    th=head;
    while(k!=0) {
    	th=th.next;
    	k--;
	}
    return th;
}
}