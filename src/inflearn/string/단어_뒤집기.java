package inflearn.string;

import java.io.*;

public class 단어_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringBuffer stringBuffer = new StringBuffer(br.readLine());
            bw.append(stringBuffer.reverse());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
