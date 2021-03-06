package com.tanpang.day01;

import java.util.Stack;

/**
 * #1
 * 设计一个有getMin功能的栈
 * @author tanpang
 *
 */
public class Stack01 {

	/**
	 * 两个stack，一个用来存储数据，一个用来存储当前最小值
	 */
		private Stack<Integer> stackData;
		private Stack<Integer> stackMin ;
		
		public Stack01() {
			this.stackData=new Stack<Integer>();
			this.stackMin=new Stack<Integer>();
		}
/**
 * push的规则：
 * 如果stackMin里是空的，则这个一定是最小的，入栈
 * 如果新数小于stackMin里的栈顶（也就是最小的那个），那么新数入栈		
 * 最终新数入stackData的栈
 * @param newNum
 */
		public void push(Integer newNum) {
			if(this.stackMin.isEmpty()) {
					stackMin.push(newNum);
			}else if(newNum<=this.getMin()) {
				stackMin.push(newNum);
			}
			this.stackData.push(newNum);
		}
/**
 * pop的规则和push的规则相对应：
 * 通过stackData栈顶元素与最小元素比较，如果=最小，则stackMin出栈。
 * 不等的话就不影响最小元素栈的存储
 * pop出data栈顶
 * 
 * @return
 */
		public Integer pop() {
			if(this.stackData.isEmpty()){
				throw new RuntimeException("your stack is empty");
			}
			int value = this.stackData.pop();
			if(value==this.getMin()) {
				this.stackMin.pop();
			}
			return value;
		}
		public Integer getMin() {
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("your stack is empty");
			}
			return stackMin.peek();
		}
		
		
}
