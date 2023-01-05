package boj;

import java.util.*;

public class BOJ_2668 {
    private static int[] values;
    private static boolean[] visited;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        values = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < values.length; i++) {
            int number = scanner.nextInt();
            values[i] = number;
        }

        for (int i = 1; i < values.length; i++) {
            if (resultList.contains(i)) {
                continue;
            }
            DFS(i, i);
        }

        Collections.sort(resultList);
        System.out.println(resultList.size());
        for (Integer number : resultList) {
            System.out.println(number);
        }


    }

    private static void DFS(int startIndex, int endIndex) {
        if (visited[startIndex]) {
            if (startIndex == endIndex) {
                addResult();
            }
            clear();
            return;
        }

        visited[startIndex] = true;
        int number = values[startIndex];

        DFS(number, endIndex);
    }

    private static void clear() {
        int length = visited.length;
        visited = new boolean[length];
    }

    private static void addResult() {
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                resultList.add(i);
            }
        }
    }


}
