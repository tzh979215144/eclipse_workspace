package shengfen;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] word=str.split(" ");

		for(int i=word.length-1;i>=1;i--) {
			System.out.print(word[i]+" ");
		}
		System.out.println(word[0]);
		
			
	}
}
