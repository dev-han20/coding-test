package inflearn.array;

import java.util.Scanner;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt()+2;
        scanner.nextLine();
        int[][] mountain = new int[N][N];
        int[][] check = new int[N][N];
        int result = 0;

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                mountain[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        int[] moveRow = {-1, 0, 1, 0};
        int[] moveCol = {0, 1, 0, -1};

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (check[i][j] == -1) {
                    continue;
                }

                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + moveRow[k];
                    int nc = j + moveCol[k];
                    if (mountain[i][j] > mountain[nr][nc]) {
                        count++;
                    }
                }

                if (count == 4) {
                    check[i-1][j] = -1;
                    check[i][j+1] = -1;
                    check[i+1][j] = -1;
                    check[i][j-1] = -1;
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
