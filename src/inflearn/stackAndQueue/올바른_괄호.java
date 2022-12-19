package inflearn.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                stack.push(input[i]);
                continue;
            }

            if (input[i].equals(")")) {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}
