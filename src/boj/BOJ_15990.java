package boj;

import java.io.*;

public class BOJ_15990 {
    private static int mod = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());

        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            for (int j = 1; j <= 3; j++) {
                compute(dp, i, j);
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            long sum = (dp[N][1] + dp[N][2] + dp[N][3]) % mod;
            writer.append(String.valueOf(sum));
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();

    }

    private static void compute(long[][] dp, int i, int j) {
        if (j == 1) {
            dp[i][j] = (dp[i - j][2] + dp[i - j][3]) % mod;
            return;
        }

        if (j == 2) {
            dp[i][j] = (dp[i - j][1] + dp[i - j][3]) % mod;
            return;
        }

        if (j == 3) {
            dp[i][j] = (dp[i - j][1] + dp[i - j][2]) % mod;
            return;
        }
    }
}
