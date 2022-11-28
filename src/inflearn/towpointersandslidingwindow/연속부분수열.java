package inflearn.towpointersandslidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 연속부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] info = br.readLine().split(" ");
        Queue<Integer> q = new LinkedList<>();

        int lt = 0;
        int rt = 0;
        int kCount = 0;
        int length = 0;
        int result = 0;
        while (rt <= info.length) {
            if (rt == info.length) {
                result = Math.max(result, length);
                break;
            }

            if (info[rt].equals("1")) {
                length++;
                rt++;
                continue;
            }

            if (info[rt].equals("0")) {
                if (kCount < K) {
                    q.offer(rt);
                    length++;
                    kCount++;
                    rt++;
                    continue;
                }

                result = Math.max(result, length);
                int ltIndex = q.poll();
                kCount--;
                lt = ltIndex + 1;
                length = rt - lt;

            }
        }
        System.out.println(result);

    }
}
