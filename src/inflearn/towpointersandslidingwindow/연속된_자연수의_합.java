package inflearn.towpointersandslidingwindow;

import java.util.Scanner;

public class 연속된_자연수의_합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int lt = 1;
        int rt = 1;
        int sum = 0;
        int result = 0;
        int count = 0;

        while (rt <= N) {
            if (sum < N) {
                sum += rt;
                count++;
                rt++;
                if (rt > N) {
                    if (sum == N && count >= 2) {
                        result++;
                    }
                }
                continue;
            }

            if (sum > N) {
                sum -= lt;
                lt++;
                count--;
                continue;
            }

            if (sum == N && count >= 2) {
                result++;
                sum += rt;
                count++;
                rt++;
                if (rt > N) {
                    if (sum == N && count >= 2) {
                        result++;
                    }
                }
                continue;
            }
        }

        System.out.println(result);
    }
}
