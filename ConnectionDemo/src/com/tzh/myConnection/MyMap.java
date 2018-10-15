package com.tzh.myConnection;

import java.util.Objects;

public class MyMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
//HashMap
	static class Node<K,V>{
		final int hash;
		final K key;
		V value;
		Node<K,V> next;
		public Node(int hash, K key, V value, Node<K, V> next) {
			super();
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
		public final V getValue() {
			return value;
		}
		public final V setValue(V value) {
			V old=this.value;
			this.value = value;
			return old;
		}
		public Node<K, V> getNext() {
			return next;
		}
		public void setNext(Node<K, V> next) {
			this.next = next;
		}
		public final int getHash() {
			return hash;
		}
		public final K getKey() {
			return key;
		}
		public final int hashcode() {
			return Objects.hashCode(key)^Objects.hashCode(value);
		}
		public final boolean equal(Object o) {
			if(o==this) {
				return true;
			}
			
		}
		
	}
}
