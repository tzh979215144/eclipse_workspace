package com.tzh.pro1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.omg.PortableInterceptor.INACTIVE;
/**
 * 工具包：排序
 * 泛型方法：是否拥有泛型方法，与其所在的类是否泛型没有关系。
 * 要定义泛型方法，只需将泛型参数列表置于返回值前
 *	 
 */

public class sortUtils {


/**
 * 容器排序（使用泛型方法）--------3
 * @author tzh
 *
 */
	
	public static <T extends Comparable<T>> void sort(List<T> list) {
		//第一步：List转数组
//		T[] arr = (T[])list.toArray();   也可以
		Object[] arr = (Object[])list.toArray();
		//第二步：数组排序,两种方法都是调用2的sort
		sort(arr);
		//第三步：改变List的值
		for(int i=0;i<arr.length;i++) {
			
			list.set(i, (T)arr[i]);
		}
		
	}
	/**
	 * 数组排序（使用泛型方法）--------2
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort (T[] arr) {
		//从小到大排序
		System.out.println("**2***");
		boolean sorted= true;
		int len = arr.length;
		for(int j =0 ; j<len-1;j++) {//躺数
			sorted = true;   //假定有序
			for(int i =0; i<len-j-1;i++) {//次数
				if(  ((Comparable)arr[i]).compareTo(arr[i+1])<0) {//降序令条件>0即可
					T temp =arr[i];
					arr[i]=arr[i+1];
					arr[i+1]= temp;
					sorted = false; //假定失败
				}

				}
			if(sorted) {//减少趟数
				break;
				
			}
		};
	}
	
	/**
	 * 数组排序（降序）-------------1
	 * @param arr
	 */
	public static  void sort (Object[] arr) {
		//从小到大排序
		System.out.println("调用的是***1***");
		boolean sorted= true;
		int len = arr.length;
		for(int j =0 ; j<len-1;j++) {//躺数
			sorted = true;   //假定有序
			for(int i =0; i<len-j-1;i++) {//次数
				if(  ((Comparable)arr[i]).compareTo(arr[i+1])<0) {//降序令条件>0即可
					Object temp =arr[i];
					arr[i]=arr[i+1];
					arr[i+1]= temp;
					sorted = false; //假定失败
				}
				}
			if(sorted) {//减少趟数
				break;
				
			}
		};
	}
	
	public static void main(String[] args) {
		List<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(9);
		test.add(2);
		test.add(15);
		test.add(3);
		test.add(8);
		System.out.println("\n======Collections排序前=====");
		Iterator<Integer> it = test.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+"\t");
		}
		sort(test);//容器排序
		 System.out.println("\n======Collections排序后=====");
		Iterator<Integer> it2 = test.iterator();
		while(it2.hasNext()) {
			System.out.print(it2.next()+"\t");
		}
		
		
	}
	
}
