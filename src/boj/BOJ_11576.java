package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ_11576 {
//    17 8
//            2
//            2 16

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] jins = line.split(" ");
        int A = Integer.valueOf(jins[0]);
        int B = Integer.valueOf(jins[1]);
        int m = Integer.valueOf(reader.readLine());
        int[] numbers = new int[m];

        String[] lines = reader.readLine().split(" ");
        for (int i = 0; i < lines.length; i++) {
            numbers[m-1-i] = Integer.valueOf(lines[i]);
        }

        // 십진법 변환
        int decimalNumber = decimalConvert(numbers, A);

        List<Integer> convertNumbers = convert(decimalNumber, B);

        for (Integer convertNumber : convertNumbers) {
            System.out.print(convertNumber + " ");
        }
    }

    private static List<Integer> convert(int decimalNumber, int B) {
        LinkedList<Integer> list = new LinkedList<>();
        int mok = 0;
        int na = 0;
        while (true) {
            mok = decimalNumber / B;
            na = decimalNumber % B;
            list.addFirst(na);
            if (mok == 0) {
                break;
            }
            decimalNumber = mok;
        }

        return list;
    }

    public static int decimalConvert(int[] numbers, int number) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += (numbers[i] * (int) Math.pow(number, i));
        }
        return result;
    }
}
