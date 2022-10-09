package inflearn.string;

import java.util.Scanner;

public class 대소문자_변환 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
				int c = (int)word.charAt(i) - 32;
				sb.append((char)c);
			} else {
				int c = (int)word.charAt(i) + 32;
				sb.append((char)c);
			}
		}

		System.out.println(sb.toString());

		char a = 'a';
		char A = 'A';

		char z = 'z';
		char Z = 'Z';

		int i = 65;
		System.out.println((char)i);

		System.out.println((int) a);
		System.out.println((int) z);
		System.out.println((int) A);
		System.out.println((int) Z);
	}
}
