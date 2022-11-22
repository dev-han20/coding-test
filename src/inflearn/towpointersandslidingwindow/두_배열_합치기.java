package inflearn.towpointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두_배열_합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());
        String[] arrayA = br.readLine().split(" ");
        int N2 = Integer.parseInt(br.readLine());
        String[] arrayB = br.readLine().split(" ");

        int[] result = new int[N1 + N2];
        int ltA = 0;
        int ltB = 0;

        for (int i = 0; i < result.length; i++) {
            if (ltA == N1) {
                result[i] = Integer.parseInt(arrayB[ltB]);
                ltB++;
                continue;
            }

            if (ltB == N2) {
                result[i] = Integer.parseInt(arrayA[ltA]);
                ltA++;
                continue;
            }

            int A = Integer.parseInt(arrayA[ltA]);
            int B = Integer.parseInt(arrayB[ltB]);
            if (A > B) {
                result[i] = B;
                ltB++;
            } else {
                result[i] = A;
                ltA++;
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }

    }



}
