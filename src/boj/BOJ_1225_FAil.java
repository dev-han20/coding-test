package boj;

import java.util.Scanner;

public class BOJ_1225_FAil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = sc.next().split("");
        String[] B = sc.next().split("");

        long result = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long numA = Integer.parseInt(A[i]);
                long numB = Integer.parseInt(B[j]);

                long multiply = numA * numB;
                result = result + multiply;
            }
        }
        System.out.println(result);
    }

}
