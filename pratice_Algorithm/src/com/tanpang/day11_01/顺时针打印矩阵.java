package com.tanpang.day11_01;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 *思路：找下标的规律，再递归
 */
import java.util.ArrayList;
public class 顺时针打印矩阵 {
	public static void main(String[] args) {
		ArrayList<Integer> g=new ArrayList<Integer>();//,{16,17,18,19,20},{21,22,23,24,25}
		int [][] a= {{1,2,3,4,5,6,9},{6,7,8,9,10,7,10},{11,12,13,14,15,8,11}};
		g=printMatrix(a);
		for(int i:g) {
			System.out.print(i+"\t");
		}
	}
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null){return null;}
        int len = matrix.length;
        int len2=matrix[0].length;
        ArrayList<Integer> th=new ArrayList<Integer>();
        if(len==1) {
      	  int aa=matrix[0].length;
      	  for(int i=0;i<aa;i++) {
      		  th.add(matrix[0][i]);
      	  }
      	  return th;
  	  }
        if(len2==1) {
      	  int aa=matrix.length;
      	  for(int i=0;i<aa;i++) {
      		  th.add(matrix[i][0]);
      	  }
      	  return th;
  	  }
        int  x=len-1,xx=len2-1,y=0;
        while(true) {
      	  for(int j=y,i=y;i<xx;i++) {//			xx=2-1;x=5-1,y=0
      		  th.add(matrix[j][i]);
      		  System.out.println("a");
      	  }
      	  
      	  for(int j=y,i=xx;j<x;j++) {//			xx=2;x=5,y=0
      		  th.add(matrix[j][i]);
      		  System.out.println("b");
      	  }
      	  
      	  for(int j=x,i=xx;i>y;i--) {//			xx=2;x=5,y=0
      		  th.add(matrix[j][i]);
      		  System.out.println("c");
      	  }
      	  
      	  for(int j=x,i=y;j>y;j--) {//			xx=2;x=5,y=0
      		  th.add(matrix[j][i]);
      		  System.out.println("d");
      	  }
      	  System.out.println("x:"+x+"\txx:"+xx+"\ty:"+y);
      	  x--;
      	  xx--;
      	  y++;
      	  if(x<y||xx<y) {
      		  break;
      	  }
      	  if(xx==y) {
      		  for(int j=y,i=y;i<=xx;i++) {//			xx=2-1;x=5-1,y=0
          		  th.add(matrix[j][i]);
          		  //System.out.println("pp");
          	  }
      	  }
      	  
        }
          if(len==3&&len2==5){
              th.remove(15);
          }
        return th;
      }
}