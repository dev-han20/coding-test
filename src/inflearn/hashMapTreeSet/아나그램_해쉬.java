package inflearn.hashMapTreeSet;

import java.util.*;
import java.util.stream.Collectors;

public class 아나그램_해쉬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] word = sc.next().split("");
        String[] otherWord = sc.next().split("");

        Map<String, Integer> wordElement = new TreeMap<>();
        Map<String, Integer> otherWordElement = new TreeMap<>();

        for (String s : word) {
            wordElement.put(s, wordElement.getOrDefault(s, 0) + 1);
        }

        for (String s : otherWord) {
            otherWordElement.put(s, otherWordElement.getOrDefault(s, 0) + 1);
        }

        List<Integer> wordList = new ArrayList<>(wordElement.values());
        List<Integer> otherWordList = new ArrayList<>(otherWordElement.values());

        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i) == otherWordList.get(i)) {
                continue;
            }
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }


}
