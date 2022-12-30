package inflearn.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주_구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Queue<Integer> startQueue = new LinkedList<>();
        Queue<Integer> endQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            startQueue.offer(i);
        }
        int count = 0;
        while (startQueue.size() != 1) {
            while (!startQueue.isEmpty()) {
                count++;
                int poll = startQueue.poll();
                if (count == K) {
                    count = 0;
                    continue;
                }
                endQueue.offer(poll);
            }
            startQueue.addAll(endQueue);
            endQueue.clear();
        }

        System.out.println(startQueue.peek());
    }
}
