package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BOJ_1931 {
    private static class MeetigInfo implements Comparable<MeetigInfo>{
        int start;
        int end;
        int time;

        public MeetigInfo(int start, int end) {
            this.start = start;
            this.end = end;
            this.time = end - start;
        }

        @Override
        public String toString() {
            return "MeetigInfo{" +
                    "start=" + start +
                    ", end=" + end +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(MeetigInfo o) {
            if (this.end - o.end == 0) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int meetingCount = Integer.parseInt(reader.readLine());

        List<MeetigInfo> infos = new ArrayList<>();

        for (int i = 0; i < meetingCount; i++) {
            String[] se = reader.readLine().split(" ");
            int start = Integer.parseInt(se[0]);
            int end = Integer.parseInt(se[1]);
            infos.add(new MeetigInfo(start, end));
        }

        Collections.sort(infos);
//        infos.forEach(meetigInfo -> System.out.println(meetigInfo));

        Stack<MeetigInfo> stack = new Stack<>();

        for (int i = 0; i < infos.size(); i++) {
            if (i == 0) {
                stack.push(infos.get(i));
                continue;
            }

            if (stack.peek().end <= infos.get(i).start) {
                stack.push(infos.get(i));
            }
        }

        System.out.println(stack.size());
    }
}
