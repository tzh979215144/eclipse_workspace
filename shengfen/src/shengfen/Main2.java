package shengfen;

import java.util.Scanner;

public class Main2 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			str=str.replaceAll(" ", "");
			str=str.replaceAll("\\d+", "").toLowerCase();
			int[] num = new int[26];
			for (int i = 0; i < str.length(); i++)
			{
				char c = str.charAt(i);//依次取出每个字母
				int index=c-'a';//这样就可以得到每个字母对应的数组下标
				num[index]= num[index]+1;//对应字母出现则存储字母的数组加1
				if(num[index]==3) {
					System.out.println(c);
					break;
				}
			}
			
			
			
			
			
			
			
		}
		
		
		
}
