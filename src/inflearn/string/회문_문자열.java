package inflearn.string;

import java.util.Scanner;

public class 회문_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine()
                .toLowerCase()
                .toCharArray();

        int converter = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[converter - i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
