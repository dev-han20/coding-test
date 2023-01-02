package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16194 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] calMap = new int[N + 1][N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                calMap[i][j] = Integer.MAX_VALUE;
            }
        }


        for (int i = 0; i < N; i++) {
            P[i + 1] = scanner.nextInt();
        }

        for (int i = 1; i < calMap.length; i++) {
            for (int j = 1; j < calMap[i].length; j++) {
                if (j == 1) {
                    calMap[i][j] = P[j] * i;
                    continue;
                }

                if (i < j) {
                    calMap[i][j] = calMap[i][j - 1];
                    continue;
                }

                calMap[i][j] = Math.min((P[j] + dp[i - j]), calMap[i][j - 1]);
            }

            dp[i] = calMap[i][N];
        }

        System.out.println(dp[N]);

    }
}
