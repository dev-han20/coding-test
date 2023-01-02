package boj;

import java.util.Scanner;

public class BOJ_11727 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] dp = new int[N + 1];

        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = 1;
                continue;
            }

            if (i == 2) {
                dp[i] = 3;
                continue;
            }

            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }

        System.out.println(dp[N]);
    }

}
