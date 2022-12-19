package inflearn.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

public class 괄호문자제거 {
    //(A(BC)D)EF(G(H)(IJ)K)LM(N)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sArray = scanner.nextLine().split("");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals(")")) {

                while (!stack.peek().equals("(")) {
                    stack.pop();
                }
                stack.pop();

                continue;
            }
            stack.push(sArray[i]);
        }
        StringBuffer sb = new StringBuffer();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        StringBuffer reverse = sb.reverse();
        System.out.println(reverse);
    }
}
