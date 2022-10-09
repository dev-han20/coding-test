package inflearn.string;

import java.util.Scanner;

public class 숫자만_추출 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] chars = scanner.nextLine().toCharArray();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < chars.length; i++) {
			if (Character.isDigit(chars[i])) {
				if (sb.toString().equals("") && chars[i] == '0') {
					continue;
				}
				sb.append(chars[i]);
			}
		}

		System.out.println(sb.toString());

	}
}
