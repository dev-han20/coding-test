package inflearn.hashMapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장_해쉬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] result = scanner.next().split("");

        Map<String, Integer> score = new HashMap<>();

        for (String s : result) {
            score.put(s, score.getOrDefault(s, 0) + 1);
        }

        int maxValue = 0;
        String chief = "";

        for (Map.Entry<String, Integer> entry : score.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                chief = entry.getKey();
            }
        }
        System.out.println(chief);

    }
}
