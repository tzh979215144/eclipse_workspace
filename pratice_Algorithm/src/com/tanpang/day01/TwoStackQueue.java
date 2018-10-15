package com.tanpang.day01;

import java.util.Stack;

/**
 * #5
 * 两个栈实现一个队列，实现add，poll，peek操作
 * @author tanpang
 *
 */
public class TwoStackQueue {

	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStackQueue() {
		stackPush=new Stack<Integer>();
		stackPop=new Stack<Integer>();
	}
	public void  add(int pushInt) {
		stackPush.push(pushInt);
	}
	/**
	 * 从最开始，stackPop是空的，poll执行时会把stackPush的内容全部转移到Pop里
	 * 往后只要POP不是空的就不用再转移数据（从Push-->Pop），直接pop出去即可
	 * @return
	 */
	public Integer poll() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException("your Queue is empty");
		}else if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public Integer peek() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException("your Queue is empty");
		}else if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
	
}
