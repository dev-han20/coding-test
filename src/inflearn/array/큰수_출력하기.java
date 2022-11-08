package inflearn.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 큰수_출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		bw.append(arr[0]);
		bw.append(" ");
		for (int i = 1; i < arr.length; i++) {
			if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i-1])) {
				bw.append(arr[i]);
				bw.append(" ");
			}
		}
		bw.flush();
	}



}
