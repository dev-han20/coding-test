package inflearn.string;

import java.util.Scanner;

public class 특정_문자_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();

        char[] chars = string.toCharArray();
        char[] reversChars = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                reversChars[i] = '1';
                continue;
            }
            reversChars[i] = chars[i];
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isLetter(chars[i])) {
                for (int j = 0; j < reversChars.length; j++) {
                    if (Character.isDigit(reversChars[j])) {
                        reversChars[j] = chars[i];
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < reversChars.length; i++) {
            System.out.print(reversChars[i]);
        }

    }
}
