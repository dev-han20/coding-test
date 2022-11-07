package programmers.level.zero;


public class 분수의_덧셈 {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int min = Math.min(num1, num2);
        if ((num1 % min) == 0 && (num2 % min) == 0) {
            int num1Mok = num1 / min;
            int num2Mok = num2 / min;
            int compare = Integer.compare(num1Mok, num2Mok);
            if (compare == -1) {
                int newNum1 = num1 * num2Mok;
                int newDenum1 = denum1 * num2Mok;
            } else if (compare == 1) {
                int newNum2 = num2 * num1Mok;
                int newDenum2 = denum2 * num1Mok;
            }





        }
        int[] answer = {};
        return answer;
    }
}
