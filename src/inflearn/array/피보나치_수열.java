package inflearn.array;

import java.util.Scanner;

public class 피보나치_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] fibo = new int[N+1];
        fibo[1] = 1;
        fibo[2] = 1;

        StringBuffer sb = new StringBuffer();
        sb.append(fibo[1])
          .append(" ")
          .append(fibo[2]);

        for (int i = 3; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            sb.append(" ")
              .append(fibo[i]);
        }

        System.out.println(sb.toString());
    }
}
