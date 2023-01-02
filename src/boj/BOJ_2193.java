package boj;

import java.util.Scanner;

public class BOJ_2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] dp = new long[N + 1][2];


        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i][1] = 1;
                continue;
            }

            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);

    }
}
