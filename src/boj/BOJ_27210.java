package boj;

import java.util.Scanner;

public class BOJ_27210 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        scanner.nextLine();
        String[] array = scanner.nextLine().split(" ");


        int lt = 0;
        int rt = 0;
        int count = 0;
        int maxValue = 0;

        while (rt < N) {
            if (array[lt].equals(array[rt])) {
                rt++;
                count++;
                continue;
            }

            maxValue = Math.max(count, maxValue);
            lt = rt;
            count = 0;
        }

        if (count >= 1) {
            maxValue = Math.max(count, maxValue);
        }


        System.out.println(maxValue);


    }

}
