package com.tanpang.day02;

import java.util.LinkedList;
/**
 * #36
 * 生成窗口最大值数组
 * @author tanpang
 *
 */
public class WindowMaxArr {
	public int[] getMaxWindow(int [] arr , int w) {
		if(arr == null ||w <1||arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length -w +1];
		int index = 0;
		for(int i = 0; i<arr.length;i++) {
			//如果新进的元素大，则把之前的元素都一个个弹出
			while(!qmax.isEmpty()&&arr[qmax.peekLast()] <=arr[i]) {
				qmax.pollLast();
			}
			//把最新的元素加入进去（如果是大元素，则上面while（）的操作已经把之前的元素都弹出了；
			//如果是小元素，则直接跟在之前的链表后面
			qmax.addLast(i);
			//查看当前头元素（也就是最大的），如果此元素的下标==i-w，则证明刚刚过期了，弹出即可
			if(qmax.peekFirst() == i-w) {
				qmax.pollFirst();
			}
			//如果i是大于w-1，则才刚刚满足一个窗口的位置，此时才开始赋值
			if(i>=w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
