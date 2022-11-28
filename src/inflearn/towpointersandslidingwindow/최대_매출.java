package inflearn.towpointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대_매출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] info = br.readLine().split(" ");

        int count = 0;
        int lt = 0;
        int maxValue = 0;
        int currentValue = 0;
        for (int rt = 0; rt < info.length; rt++) {
            if (count != K) {
                maxValue += Integer.parseInt(info[rt]);
                currentValue = maxValue;
                count++;
                continue;
            }

            int nextValue = currentValue - Integer.parseInt(info[lt]) + Integer.parseInt(info[rt]);
            maxValue = Math.max(nextValue, maxValue);
            currentValue = nextValue;
            lt++;
        }

        System.out.println(maxValue);

    }

}
