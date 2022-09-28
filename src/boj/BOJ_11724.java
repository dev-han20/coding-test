package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11724 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = bufferedReader.readLine().split(" ");

        int nodeCount = Integer.parseInt(NM[0]);
        int edgeCount = Integer.parseInt(NM[1]);
        int connectCount = 0;

        if (nodeCount == 1) {
            System.out.println(1);
            return;
        }

        if (edgeCount == 0) {
            System.out.println(nodeCount);
            return;
        }

        int[] visited = new int[nodeCount+1];
        int[][] graph = new int[nodeCount+1][nodeCount+1];

        for (int i = 0; i < edgeCount; i++) {
            String[] edgeInfo = bufferedReader.readLine().split(" ");
            int node = Integer.parseInt(edgeInfo[0]);
            int otherNode = Integer.parseInt(edgeInfo[1]);
            graph[node][otherNode] = 1;
            graph[otherNode][node] = 1;
        }

        for (int i = 1; i < visited.length; i++) {
            visited[i] = 1;
        }

        Queue<Integer> visitQueue = new LinkedList<>();

        boolean repeat = true;
        while (repeat) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 1) {
                    visitQueue.offer(i);
                    visited[i] = 2;
                    break;
                }

                if (visited.length-1 == i) {
                    repeat = false;
                }
            }

            while (!visitQueue.isEmpty()) {
                int node = visitQueue.poll();

                for (int i = 0; i < graph[node].length; i++) {
                    if (graph[node][i] == 1 && visited[i] == 1) {
                        visitQueue.offer(i);
                        visited[i] = 2;
                    }
                }
            }
            if (repeat) {
                connectCount++;
            }
        }
        System.out.println(connectCount);
    }
}
