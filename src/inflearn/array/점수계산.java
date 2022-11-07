package inflearn.array;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 1) {
                result[i] = result[i-1] + 1;
                continue;
            }
        }

        int count = 0;
        for (int i = 0; i < result.length; i++) {
            count += result[i];
        }
        System.out.println(count);


    }
}
