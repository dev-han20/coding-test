package boj;

import java.io.*;
import java.util.Scanner;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
//        String line;
//        while(!(line= reader.readLine()).equals("")){
        while (scanner.hasNextInt()) {

//            int N = Integer.parseInt(line);
            int N = scanner.nextInt();
            int number = 0;

            for (int i = 1; ; i++) {
                number = (number * 10) + 1;
                number = number % N;
                if (number == 0) {
                    System.out.println(i);
                    break;
//                    writer.append(String.valueOf(i));
//                    writer.newLine();
//                    break;
                }
            }
//            long count = 1;

//            while (number % N != 0) {
//                number = (number * 10) + 1;
//                number = number % N;
//                count++;
//            }

        }

//        writer.flush();
//        reader.close();
//        writer.close();
    }

}
