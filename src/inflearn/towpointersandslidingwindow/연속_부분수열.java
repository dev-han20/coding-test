package inflearn.towpointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속_부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] info = br.readLine().split(" ");
        int[] numbers = new int[info.length+1];
        for (int i = 0; i < info.length; i++) {
            numbers[i] = Integer.parseInt(info[i]);
        }

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int result = 0;
        while (rt < numbers.length) {
            if (sum < M) {
                sum += numbers[rt];
                rt++;
                continue;
            }

            if (sum > M) {
                sum -= numbers[lt];
                lt++;
                continue;
            }

            if (sum == M) {
                result++;
                sum += numbers[rt];
                rt++;
                continue;
            }
        }
        System.out.println(result);

    }
}
