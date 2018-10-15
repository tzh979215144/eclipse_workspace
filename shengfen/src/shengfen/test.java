package shengfen;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[18];
		int j=0;
		while(sc.hasNextLine()) {
			str[j]=sc.nextLine();
			str[j]=str[j].replaceAll(" ", "");
			j++;
		}
		for(int i=0;i<j-1;i++) {
			if(str[i].length()==18) {
				System.out.println(str[i].substring(0, 6)+" "+str[i].substring(6, 14)+" "+str[i].substring(14, 18));
			}else if(str[i].length()>14&&str[i].length()<=18) {
				System.out.println(str[i].substring(0, 6)+" "+str[i].substring(6, 14)+" "+str[i].substring(14));
			}else if(str[i].length()>6&&str[i].length()<=14) {
				System.out.println(str[i].substring(0, 6)+" "+str[i].substring(6));
			} else if(str[i].length()>0&&str[i].length()<=6){
				System.out.println(str[i].substring(0));
			}
		}
	}
}
