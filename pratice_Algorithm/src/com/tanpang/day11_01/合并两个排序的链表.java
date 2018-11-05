package com.tanpang.day11_01;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *思路：将两个链表合并了，再用快排
 * @author tanpang
 *
 */
public class 合并两个排序的链表 {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null&&list2==null) {return null;}
		if(list1==null&&list2!=null) {return list2;}
		if(list1!=null&&list2==null) {return list1;}
		ListNode ls=list1;
		int len=0;
		while(ls.next!=null) {
				 	ls=ls.next;
				 	len++;
			 }
		len++;
		//此时ls为尾节点
		ls.next=list2;
		while(ls.next!=null) {
			ls=ls.next;
			len++;
		}
		ls=list1;
		int[] sa=new int[len];
		for(int i=0;i<len;i++) {
			sa[i] = ls.val;
			ls=ls.next;
		}
		quickSort(sa);
		ls=list1;
		for(int i=0;i<len;i++) {
			ls.val=sa[i];
			ls=ls.next;
		}
		return list1;
    }
	/**
	 * 快排
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
