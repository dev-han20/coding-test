package inflearn.string;

import java.util.Scanner;

public class 유효한_팰린드롬 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] chars = scanner.nextLine().toCharArray();
		// int lastIndex = chars.length - 1;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isLetter(chars[i])) {
				sb.append(chars[i]);
			}
		}

		char[] charArray = sb.toString().toCharArray();
		int converter = charArray.length - 1;

		for (int i = 0; i < charArray.length; i++) {
			if (converter - i < i) {
				break;
			}
			if (Character.isLetter(charArray[i])) {
				if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(charArray[converter - i])) {
					continue;
				}
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
