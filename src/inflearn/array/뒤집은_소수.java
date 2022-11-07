package inflearn.array;

import java.util.Scanner;

public class 뒤집은_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < N; i++) {
            StringBuffer sb = new StringBuffer(String.valueOf(sc.nextInt()));
            int reversNum = Integer.parseInt(sb.reverse().toString());
            if (primeCheck(reversNum)) {
                result.append(reversNum);
                result.append(" ");
            }
        }
        System.out.println(result.toString());
    }

    private static boolean primeCheck(int reversNum) {
        if (reversNum == 1) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(reversNum); i++) {
            if (reversNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
