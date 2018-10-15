package tengxun;

/**
 * 问题描述：给一个数n，存在大于n的整数m有，lcm（n+1，n+2，..，m）=lcm(1,2,3,....m),
 * 求符合条件的最小的m
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		
		//输入一个数n
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		long q=1;
		long x=n+1;
		int j=1;
		boolean flag =false;
		//处理数n
			//m从n开始测试
		for(int m=n+1;;m++) {
			//调用最小公倍数算法
			x=get_lcm(x,m);
			System.out.println(x);
			if(flag==flag)
				for(;j<=m;j++) {
				q=get_lcm(q,j);
				}
			else {
				q=get_lcm(q,j);
				j++;
			}
			System.out.println(q);
			if(x==q) {
				q=m;
				break;
			}else {
//				q=1;
				flag=true;
			}
		
		}
		
		//通过q返回结果m
		System.out.println(q);
	
	}
	
	    // 最大公约数
	    public static long get_gcd(long a, long l) {
	        long max, min;
	        max = (a > l) ? a : l;
	        min = (a < l) ? a : l;

	        if (max % min != 0) {
	            return get_gcd(min, max % min);
	        } else
	            return min;

	    }

	    // 最小公倍数
	    public static long get_lcm(long a, long b) {
	        return a * b / get_gcd(a, b);
	    }
}
