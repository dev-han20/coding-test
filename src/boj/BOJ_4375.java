package boj;

import java.io.*;

public class BOJ_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while(!(line= reader.readLine()).equals("")){
            int N = Integer.parseInt(line);
            long number = 1;
            long count = 1;

            while (number % N != 0) {
                number = number * 10 + 1;
                count++;
            }
            writer.append(String.valueOf(count));
            writer.newLine();
        }

        writer.flush();
        reader.close();
        writer.close();
    }

}
