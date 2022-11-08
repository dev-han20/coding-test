package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 격자판_최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        int[] rowSumList = new int[N];
        int[] colSumList = new int[N];
        int leftDiagonalSumList = 0;
        int rightDiagonalSumList = 0;

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            for (int j = 0; j < strings.length; j++) {
                int num = Integer.parseInt(strings[j]);
                grid[i][j] = num;
                rowSumList[i] += num;
                colSumList[j] += num;

                if (i == j) {
                    leftDiagonalSumList += num;
                }
                if (i == (N - 1 - j)) {
                    rightDiagonalSumList += num;
                }
            }
        }

        Arrays.sort(rowSumList);
        Arrays.sort(colSumList);

        int max = Math.max(rowSumList[N - 1], colSumList[N - 1]);
        int otherMax = Math.max(leftDiagonalSumList, rightDiagonalSumList);
        System.out.println(Math.max(max, otherMax));
    }
}
