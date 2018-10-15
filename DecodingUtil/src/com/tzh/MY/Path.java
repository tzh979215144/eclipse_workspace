package com.tzh.MY;

import java.io.File;
import java.io.IOException;

public class Path {
	
	public static void main(String[] args) throws IOException {
		String src1="/home/tzh/Documents/Blog";
		String src2="/home/tzh/下载/java尚学堂/IO流/源码与笔记/IO";
		String src3="/home/tanpang/桌面/Tools/s";
		String src4="/home/tanpang/eclipse-workspace/源代码1";
		
		String dest1="/home/tzh/Documents/Blog2";		
		String dest2="/home/tzh/下载/java尚学堂/IO流/源码与笔记/newIO";
		String dest3="/home/tanpang/桌面/Tools/ss";
		String dest4="/home/tanpang/eclipse-workspace/new";
		
		demo1 test = new demo1(src1,dest1);
		demo1 test2=new demo1(src2,dest2);
		demo1 test3=new demo1(src3,dest3);
		demo1 test4=new demo1(src4,dest4);
		//test2.start();
		test3.start();
		//test3.start();
		//test4.start();
	}
}
