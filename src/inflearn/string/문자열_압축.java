package inflearn.string;

import java.util.Scanner;

public class 문자열_압축 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char[] chars = scanner.nextLine().toCharArray();
		StringBuffer sb = new StringBuffer();
		int rt = 0;
		for (int i = 0; i < chars.length; i++) {
			rt = i;
			int count = 0;
			while (true) {
				if (chars[i] == chars[rt]) {
					count++;
					if (rt == chars.length - 1) {
						sb.append(chars[i]);
						sb.append(count);
						i = rt;
						break;
					} else {
						rt++;
					}
				} else {
					sb.append(chars[i]);
					sb.append(count);
					i = rt - 1;
					break;
				}
			}
		}

		System.out.println(sb.toString().replaceAll("1", ""));
	}
}
