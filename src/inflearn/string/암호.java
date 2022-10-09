package inflearn.string;

import java.util.Scanner;

public class 암호 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.nextLine());
		char[] chars = scanner.nextLine().trim().toCharArray();

		char[][] arr = new char[N][7];

		for (int i = 0; i < chars.length; i++) {
			int row = i / 7;
			int col = i % 7;
			arr[row][col] = chars[i];
		}


		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == '#') {
					arr[i][j] = '1';
				} else {
					arr[i][j] = '0';
				}
			}
		}

		int[] result = new int[N];

		for (int i = 0; i < arr.length; i++) {
			double temp = 0;
			for (int j = 0; j < arr[i].length; j++) {

				temp += (Math.pow(2, 6 - j) * Integer.parseInt(String.valueOf(arr[i][j])));
			}
			result[i] = (int)temp;
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print((char)result[i]);

		}


	}
}
