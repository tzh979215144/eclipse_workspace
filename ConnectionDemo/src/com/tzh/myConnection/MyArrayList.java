package com.tzh.myConnection;

import java.util.Arrays;

public class MyArrayList<T>  /*implements List*/{

	private Object[] elementData;
	private int size;//当前有几条内容
	/**
	 * 默认初始化容量为10
	 */
	public MyArrayList() {
		this(10);
	}
	/**
	 * 构造器初始化容量
	 * @param initialCapacity
	 */
	public MyArrayList(int initialCapacity) {
		
		elementData = new Object[initialCapacity];
	}
	
	public int size() {
		return size;
	}
	public void add(Object obj) {
		//判断容量是否不足
		ensureCapacity();
		//为elementData后添加obj，同时size增加一
		elementData[size++] = obj;
	}
	//通过索引获取对象
	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	
	//改变指定索引位置的对象,返回此旧对象
	public Object set(int index, Object obj) {
		rangeCheck(index);
		Object old = elementData[index];
		elementData[index] = obj;
		return old;
	}
	
	//移除索引处元素，返回被移除的元素
	public Object remove(int index) {
		rangeCheck(index);
		Object old = elementData[index];
		Object[] newArray = elementData;//对象的引用-->指向同一对象
		elementData[index]="gai";
		// 0 1 2 3 4===4 - 1=3 = size-index
		System.arraycopy(newArray,index+1, elementData, index, size-index);
		/*for(Object temp:elementData) {//测试输出
			System.out.println(temp);
		}*/
		return old;
	}
	
	//移除指定元素，返回布尔值是否移除成功
	public boolean remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(elementData[i].equals(obj)) {
				remove(i);
				return true;
			}			
		}
		return false;
	}
	//转数组
	public Object[] toArray() {
		return Arrays.copyOf(elementData,size);
	}
	//数组扩容和数据的拷贝
	private void ensureCapacity() {
		if(size==elementData.length) {
			//以二倍加一扩容
			Object[] newArray = new Object[size*2+1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			//改变elementData的数据
			elementData = newArray;
		}
	}
	public MyArrayList(Object[] elementData, int size) {
		super();
		this.elementData = elementData;
		this.size = size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public Object[] getElementData() {
		return elementData;
	}
	public void setElementData(Object[] elementData) {
		this.elementData = elementData;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
		MyArrayList<String> stu = new MyArrayList<String>();
		stu.add("tzh");
		stu.add("nihao");
		System.out.println(stu.remove("nihao"));
		for(Object temp:stu.toArray()) {//测试输出
			System.out.println((String)temp);
		}
	}	
}
