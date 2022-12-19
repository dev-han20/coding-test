package inflearn.stackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 크레인_인형뽑기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Stack<Integer>> map = new ArrayList<>();
        Stack<Integer> resultStack = new Stack<>();
        int popCount = 0;

        int[][] tempMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    map.add(new Stack<>());
                }
                tempMap[i][j] = sc.nextInt();
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int temp = tempMap[i][j];
                if (temp != 0) {
                    map.get(j).push(temp);
                }
            }
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int move = sc.nextInt() - 1;

            Stack<Integer> selected = map.get(move);
            if (selected.isEmpty()) {
                continue;
            }

            int pop = selected.pop();

            if (resultStack.isEmpty()) {
                resultStack.push(pop);
                continue;
            }

            if (resultStack.peek() == pop) {
                resultStack.pop();
                popCount++;
                continue;
            }

            resultStack.push(pop);
        }
        System.out.println(popCount*2);
    }
}
