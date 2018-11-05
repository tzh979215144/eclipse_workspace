package com.tanpang.day10_31;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：	1、先了解java的int二进制如何表示（范围是：-2147483648~2147483647）
 * 					在二进制中，0有两种表方法：
							+0的原码为0000 0000 0000 0000 0000 0000 0000 0000，
							-0的原码为1000 0000 0000 0000 0000 0000 0000 0000，
							因为0只需要一个，所以把-0拿来当做一个最小的数-2147483648。
				2、正数的原码反码补码相等；负数而反码等于原码符号位不变，其余各位取反，补码等于反码加1
    			
    			3、编程思路:
    								while循环将int数字不断的求余数，数字自身除二
    								用count存储循环次数：作为最高位的标志号
    								当第一次余数为1时，用flag标记下此时的循环次数，为了求补码时加一操作方便
    								用num记录每当余数为1时，num加加
    								
    								如果是正数，直接执行上面即可，num就是1的个数；
    								如果是零，则输出0；
    								如果是-2147483648，则输出1；
    								else：
    								如果是负数，先取绝对值，再执行上面的得到原码特征-->再求反码中1的个数：32-num（原来是0的现在就是1）
    								反码和补码直接就相差了，flag-2个1，即补码的个数=反码的个数-（flag-2）
 * @author tanpang
 *
 */
public class 二进制中1的个数 {
	public static void main(String[] args) {
		System.out.println(NumberOf1(24));
	}
		public static int NumberOf1(int n) {
				int count=1,flag=0,num=0;
				boolean ff=true;
				if(n==0) {return 0;}
				if(n==-2147483648) {return 1;}
				if(n==-1){ return 32;}
				if(n<0) {ff=false;}
				n=Math.abs(n);
				while(n!=0) {
					if(n%2==1) {
						num++;
						if(flag==0) {
							flag=count;
						}
					}
					n=n/2;
					count++;
				}
				if(ff==true) {
					return num;
				}else {
					num=32-num-flag+2;
					return num;
				}
    }
}
