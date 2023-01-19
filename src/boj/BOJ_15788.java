package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15788 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        long[][] map = new long[N + 1][N + 1];

        int[] zeroLocation = new int[2];

        long diaRightSum = 0;
        long diaLeftSum = 0;

        long sumCheck = 0;

        // 가로 섬
        for (int i = 0; i < N; i++) {
            String[] rowInfos = reader.readLine().split(" ");
            long rowSum = 0;


            for (int j = 0; j < rowInfos.length; j++) {
                long number = Integer.parseInt(rowInfos[j]);
                map[i][j] = number;

                if (number == 0) {
                    zeroLocation[0] = i;
                    zeroLocation[1] = j;
                }

                rowSum += number;
            }

            map[i][N] = rowSum;
            diaRightSum += map[i][i];

            if (rowSum > sumCheck) {
                sumCheck = rowSum;
            }
        }

        // 세로 섬
        for (int i = 0; i < N; i++) {
            long colSum = 0;
            for (int j = 0; j < N; j++) {
                colSum += map[j][i];
            }
            map[N][i] = colSum;
            diaLeftSum += map[i][N - 1 - i];
        }

        long compareSum = map[zeroLocation[0]][N];

        long diff = Math.abs(sumCheck - compareSum);
        map[zeroLocation[0]][zeroLocation[1]] = diff;

        map[zeroLocation[0]][N] += diff;
        map[N][zeroLocation[1]] += diff;

        if (zeroLocation[0] == zeroLocation[1]) {
            diaRightSum += diff;
        }

        if (zeroLocation[1] == (N - 1 - zeroLocation[0])) {
            diaLeftSum += diff;
        }

        for (int i = 0; i < N; i++) {
            if (sumCheck != map[i][N] || sumCheck != map[N][i] || sumCheck != diaLeftSum || sumCheck != diaRightSum) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(diff);
    }
}
