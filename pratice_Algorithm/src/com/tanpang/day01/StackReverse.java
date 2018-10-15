package com.tanpang.day01;

import java.util.Stack;

/**
 * #8仅使用递归，实现对一个栈的逆序
 * @author tanpang
 *
 */
public class StackReverse {

	public Stack<Integer> stack;
	
	public StackReverse() {
		stack=new Stack<Integer>();
	}
	
	/**
	 * 将栈底元素返回并移除：
	 * 首先，弹出栈顶元素，如果栈空了，则此元素为栈底元素，返回此元素。
	 * 如果栈非空，则再调用此方法（递归...）
	 * 最后一步：将非栈底元素移回栈内：stack.push(result);  返回last
	 * @param stack
	 * @return
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	/**
	 * 明确一点：经过getAnd...（）方法的操作，stack的栈底是在不断地被移除
	 * 当stack被移空时，翻转取数据的操作算是完成了
	 * 最后一次获取的i一定是最后一个栈底（也就是栈顶了），然后开始push进去，于是实现了翻转
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return ;
		}
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
	
	
}
