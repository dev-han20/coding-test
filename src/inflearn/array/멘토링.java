package inflearn.array;

import java.util.Scanner;

public class 멘토링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int countOfMan = sc.nextInt();
		int countOfTest = sc.nextInt();
		int[][] info = new int[countOfTest][countOfMan];
		int[][] graph = new int[countOfMan + 1][countOfMan + 1];

		for (int i = 0; i < countOfTest; i++) {
			for (int j = 0; j < countOfMan; j++) {
				info[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info[i].length; j++) {
				int no = info[i][j];
				for (int k = j + 1; k < info[i].length; k++) {
					graph[no][info[i][k]] = 1;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if (graph[i][j] == 1 && graph[j][i] == 1) {
					continue;
				}

				if (graph[i][j] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);

	}

}
