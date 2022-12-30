package inflearn.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정_설계 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nec = scanner.nextLine().split("");
        String[] order = scanner.nextLine().split("");

        Queue<String> queue = new LinkedList<>();
        for (String s : nec) {
            queue.offer(s);
        }

        for (int i = 0; i < order.length; i++) {
            if (order[i].equals(queue.peek())) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
