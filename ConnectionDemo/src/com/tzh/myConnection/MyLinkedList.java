package com.tzh.myConnection;
/**
 * List是有序的，需要有关于索引的操作（获取，删除）
 * @author tzh
 *
 */
public class MyLinkedList {
//LinkedList
	private Node first;
	private Node last;
	
	private int size;
	
	public void add(Object obj) {
		Node n = new Node();
		if(first==null) {
			n.setPreviousNode(null);
			n.setValue(obj);
			n.setNextNode(null);
			first = n;
			last = n;
		}
		else {
			//直接往last节点后增加新的节点
			n.setNextNode(null);
			n.setPreviousNode(last);
			n.setValue(obj);
			//对对象的操作都是对其引用的操作
			last.setNextNode(n);
			//last相当于一个永远指向最后的指针
			last = n;
		}
		size++;
	}
	
	//通过索引访问Node节点
	public Node node(int index) {
		rangeCheck(index);
		Node temp = null;
		if(first!=null) {
			if(index<(size>>1)) {//索引相对于size在前部分，从first开始遍历
				temp = first;
				for(int i =0;i<index;i++) {
					temp=temp.getNextNode();
				}
			}
			else {				//索引相对于size在后部分，从last开始遍历
				temp = last;
				for(int i =size-1;i>index;i--) {
					temp=temp.getPreviousNode();
				}
			}
			return temp;
		}
		return null;
	}
	
	//通过索引访问链表的节点内的value
	public Object get(int index) {
		rangeCheck(index);
		
		Node temp = node(index);
		if(temp!=null)
			return temp.value;
		return null;
	}
	
	//删除指定对象
	public boolean remove(Object obj) {
		Node s= new Node();
		s=first;
		if(obj==first.value) {
			first.nextNode.setPreviousNode(null);
			first = first.nextNode;
			return true;
		}
		else if(obj==last.value) {
			last.previousNode.setNextNode(null);
			last = last.previousNode;
			return true;
		}
		if(first!=null&&last.getPreviousNode()!=null)
		for(int i=0;i<size;i++) {
			if(s.getValue().equals(obj)) {
				Node p= new Node();
				p=s.getPreviousNode();
				Node n= new Node();
				n=s.getNextNode();
				p.setNextNode(n);
				n.setPreviousNode(p);
				return true;
			}	
		}
		return false;
	}
	public int size() {
		return size;
	}
	
	//范围越界检查
		public void rangeCheck(int index) {
			if(index<0||index>=size){
				try {
					throw new Exception();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList stu= new MyLinkedList();
		stu.add("tan");
		stu.add("zhi");
		stu.add("heng");
		stu.add("ta");
		stu.add("shi");
		stu.add("a");
		for(int i =0;i<stu.size();i++)
		System.out.println(stu.get(i));
		System.out.println(stu.size());
	}
	private class Node {
		private Node nextNode;//下一个节点
		private Node previousNode;//上一个节点
		Object value;//自身的值
		
		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node(Node nextNode, Node previousNode, Object value) {
			super();
			this.nextNode = nextNode;
			this.previousNode = previousNode;
			this.value = value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getPreviousNode() {
			return previousNode;
		}

		public void setPreviousNode(Node previousNode) {
			this.previousNode = previousNode;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
		
		
		
	}
}
