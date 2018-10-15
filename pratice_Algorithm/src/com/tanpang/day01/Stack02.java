package com.tanpang.day01;

import java.util.Stack;

/**
 * #1
 * 这个和Stack01不同点在于：
 * 01对于newNum大于min的值的数，也对stackMin执行入栈操作，入的是min值
 * @author tanpang
 *
 */
public class Stack02 {

		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;
		
		public Stack02() {
			this.stackData=new Stack<Integer>();
			this.stackMin=new Stack<Integer>();
		}
		
		public void push(Integer newNum) {
			if(this.stackMin.isEmpty()) {
				this.stackMin.push(newNum);
			}else if(this.getMin()>=newNum) {
				this.stackMin.push(newNum);
			}else {
				this.stackMin.push(this.getMin());
			}
			this.stackData.push(newNum);
			
		}
		
		public Integer pop() {
			if(this.stackData.isEmpty()) {
				throw new RuntimeException("your stack is empty");
			}
		 int value =this.stackData.pop();
		 this.stackMin.pop();
		 return value;
		}
		public Integer getMin() {
			if(this.stackMin.isEmpty()) {
				throw new RuntimeException("your stack is empty");
			}
			return this.stackMin.peek();
		}
}
