package inflearn.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 가장_짧은_문자거리 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] split = scanner.nextLine().split(" ");

		char[] chars = split[0].toCharArray();
		char word = split[1].toCharArray()[0];

		List<Integer> indexs = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == word) {
				indexs.add(i);
			}
		}

		int[] result = new int[chars.length];
		Arrays.fill(result, Integer.MAX_VALUE);

		for (int i = 0; i < indexs.size(); i++) {
			for (int j = 0; j < result.length; j++) {
				result[j] = Math.min(Math.abs(indexs.get(i) - j), result[j]);
			}
		}

		for (int i : result) {
			System.out.print(i + " ");
		}


	}
}
