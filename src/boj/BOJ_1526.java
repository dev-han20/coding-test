package boj;

import java.util.Scanner;

public class BOJ_1526 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        String[] number = String.valueOf(A).split("");

        StringBuffer stringBuffer = new StringBuffer();

        int num = Integer.parseInt(number[0]);

        if (num < 4) {
            System.out.println("7".repeat(number.length - 1));
            return;
        }

        if (num == 4) {
            int i = Integer.parseInt("4".repeat(number.length));
            if (A >= i) {
                System.out.println(i);
                return;
            }

            System.out.println("7".repeat(number.length - 1));
            return;
        }

        if (num == 7) {
            int i = Integer.parseInt("7".repeat(number.length));
            if (A >= i) {
                System.out.println(i);
                return;
            }

            System.out.println("7".repeat(number.length - 1));
            return;
        }

        if (num > 7) {
            System.out.println("7".repeat(number.length));
        }


    }
}
