package inflearn.array;

import java.util.Scanner;

public class 소수_에라토스테네스체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] nums = new int[N + 1];

        int count = 0;
        for (int i = 2; i <= (int)Math.sqrt(N); i++) {
            for (int j = i*i; j < nums.length; j=j+i) {
                nums[j] = 1;
            }
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }
            count++;
        }

        System.out.println(count);
    }
}
