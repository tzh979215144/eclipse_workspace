package com.tanpang.day01;

public class test {

	public static void main(String[] args) {
		
	}
	
	public static void stack0102() {
		Stack01 s1=new Stack01();
		s1.push(9);
		s1.push(4);
		s1.push(5);
		s1.push(2);
		System.out.println(s1.getMin());
		s1.pop();
		System.out.println(s1.getMin());
		
		
		Stack02 s2=new Stack02();
		s2.push(9);
		s2.push(4);
		s2.push(5);
		s2.push(2);
		System.out.println(s2.getMin());
		s2.pop();
		System.out.println(s2.getMin());
	}
	
	public static void TwoStackQueue() {
		TwoStackQueue queue = new TwoStackQueue();
		queue.add(5);
		queue.add(6);
		queue.add(2);
		queue.add(9);
		queue.add(1);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.add(0);
		queue.add(8);
		System.out.println(queue.poll());
	}

	public static void StackReverse() {
		StackReverse sr =new StackReverse();
		sr.stack.push(5);
		sr.stack.push(6);
		sr.stack.push(7);
		sr.stack.push(3);
//		sr.reverse(sr.stack);//翻转
		while(!sr.stack.isEmpty()) {
		System.out.println(sr.stack.pop());
		}
	}
}
