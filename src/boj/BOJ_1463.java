package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        int[] operationCount = new int[N + 1];
        operationCount[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                operationCount[1] = 0;
                continue;
            }
            if (i == 2) {
                operationCount[2] = 1;
                continue;
            }
            if (i == 3) {
                operationCount[3] = 1;
                continue;
            }
            int result3 = 0;
            int result2 = 0;
            int result1 = 0;

            if (i % 3 == 0) {
                result3 = i / 3;
            }

            if (i % 2 == 0) {
                result2 = i / 2;
            }

            result1 = i - 1;

            operationCount[i] = findMinValue(result1, result2, result3, operationCount) + 1;
        }
        System.out.println(operationCount[N]);

    }

    private static int findMinValue(int result1, int result2, int result3, int[] operationCount) {
        return Math.min(Math.min(operationCount[result1], operationCount[result2]), operationCount[result3]);
    }

}
