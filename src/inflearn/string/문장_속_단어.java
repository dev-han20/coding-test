package inflearn.string;

import java.util.Scanner;

public class 문장_속_단어 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        int resultIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLength) {
                maxLength = words[i].length();
                resultIndex = i;
            }
        }

        System.out.println(words[resultIndex]);

    }
}
