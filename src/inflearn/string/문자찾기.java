package inflearn.string;

import java.util.Locale;
import java.util.Scanner;

public class 문자찾기 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] sArr = in.nextLine().toLowerCase().split("");
		String os = in.nextLine().toLowerCase();

		int count = 0;
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].equals(os)) {
				count++;
			}
		}

		System.out.println(count);
	}
}
