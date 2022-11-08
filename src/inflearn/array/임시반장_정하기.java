package inflearn.array;

import java.util.Scanner;

public class 임시반장_정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        int[][] info = new int[N][5];
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                int ban = info[i][j];
                for (int k = i; k < N; k++) {
                    if (ban == info[k][j]) {
                        graph[i][k] = 1;
                        graph[k][i] = 1;
                    }
                }
            }
        }

        int no = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    count++;
                }
            }

            if (count > result) {
                result = count;
                no = i + 1;
            }

        }
        System.out.println(no);
    }
}
