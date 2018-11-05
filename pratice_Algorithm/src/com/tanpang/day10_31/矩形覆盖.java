package com.tanpang.day10_31;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 *这里就像是解方程一样，x代表两竖条的（2*2），y代表一横条的(1*2），xy内部没有变化，那么现在可以考虑排列组合
 *就等于拼图游戏的拼图种类已经准备好了，看看每一种有多少种拼起来的方式
 * @author tanpang
 *
 */
public class 矩形覆盖 {
	public static void main(String[] args) {
		for(int i=1;i<20;i++) {
			System.out.println(RectCover(i));
		}
	}
	public static int RectCover(int target) {
			int n=target;
			int y=0,num=0;
			if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
			for(int x=0;x<=n/2;x++) {
				y=n-2*x;
				int max=x>y?x:y;
	        	int min=x<y?x:y;
	        	num+=jie(x+y,max)/jie(min,1);
				}
			return num;
			}
	public static long jie(int n,int n2){
        long num=1;
        while(n!=0){
        	if(n!=n2)
        		num*=n--;
        	else break;
//        	System.out.println(num+"------");
        }
//        System.out.println(num+"++++");
        return num;
    }
    
}
