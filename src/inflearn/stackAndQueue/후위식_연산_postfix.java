package inflearn.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식_연산_postfix {

    /*
    설명
    후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
    만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

    입력
    첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
    식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.

    출력
    연산한 결과를 출력합니다.
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String postfix = scanner.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
                continue;
            }

            if (c == '+') {
                int right = stack.pop();
                int left = stack.pop();
                int result = left + right;
                stack.push(result);
                continue;
            }

            if (c == '-') {
                int right = stack.pop();
                int left = stack.pop();
                int result = left - right;
                stack.push(result);
                continue;
            }

            if (c == '*') {
                int right = stack.pop();
                int left = stack.pop();
                int result = left * right;
                stack.push(result);
                continue;
            }

            if (c == '/') {
                int right = stack.pop();
                int left = stack.pop();
                int result = left / right;
                stack.push(result);
                continue;
            }
        }

        System.out.println(stack.pop());
    }
}
