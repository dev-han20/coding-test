package inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 중복문자제거 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (result.isEmpty()) {
                result.add(chars[i]);
                continue;
            }

            if (result.contains(chars[i])) {
                continue;
            }

            result.add(chars[i]);
        }

        result.forEach(System.out::print);

    }
}
