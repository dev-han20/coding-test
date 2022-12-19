package inflearn.hashMapTreeSet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class K_번째_큰수 {
    private static LinkedList<Integer> extracted = new LinkedList<>();
    private static int[] numbers;
    private static TreeSet<Integer> resultNumbers = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        int answer = -1;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int level = 0;
        int escape = 3;
        DFS(level, escape);

        int count = 1;
        for (Integer resultNumber : resultNumbers) {
            if (count != K) {
                count++;
                continue;
            }
            answer = resultNumber;
            break;
        }
        System.out.println(answer);

    }

    private static void DFS(int level, int escape) {
        if (extracted.size() == escape) {
            resultNumbers.add(computeResult());
            return;
        }

        for (int i = level; i < numbers.length ; i++) {
            extracted.addLast(numbers[i]);
            DFS(i + 1, escape);
            extracted.removeLast();
        }

    }

    private static int computeResult() {
        int result = 0;
        for (int number : extracted) {
            result += number;
        }
        return result;
    }

}
