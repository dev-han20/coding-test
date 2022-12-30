package inflearn.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Queue<Man> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Man man = new Man(i, scanner.nextInt());
            queue.offer(man);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Man man = queue.poll();

            if (!isDangerous(man.dangerous, queue)) {
                queue.offer(man);
                continue;
            }

            count++;

            if (man.index == M) {
                break;
            }
        }
        System.out.println(count);
    }

    private static boolean isDangerous(int dangerous, Queue<Man> queue) {
        for (Man man : queue) {
            if (man.dangerous > dangerous) {
                return false;
            }
        }
        return true;
    }

    private static class Man {
        private int index;
        private int dangerous;

        public Man(int index, int dangerous) {
            this.index = index;
            this.dangerous = dangerous;
        }
    }
}
