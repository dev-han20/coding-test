package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_15591 {
    static int nodeCount;
    static int questionCount;
    static long[][] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RC = reader.readLine().split(" ");

        nodeCount = Integer.parseInt(RC[0]);
        questionCount = Integer.parseInt(RC[1]);

        graph = new long[nodeCount + 1][nodeCount + 1];



        for (int i = 0; i < nodeCount - 1; i++) {
            String[] nodeInfo = reader.readLine().split(" ");
            int nodeIndex = Integer.parseInt(nodeInfo[0]);
            int otherNodeIndex = Integer.parseInt(nodeInfo[1]);
            long USADO = Integer.parseInt(nodeInfo[2]);

            graph[nodeIndex][otherNodeIndex] = USADO;
            graph[otherNodeIndex][nodeIndex] = USADO;
        }

        for (int i = 1; i < graph.length; i++) {
            visited = new int[nodeCount + 1];
            for (int j = 1; j < graph[i].length; j++) {


            }


        }

        for (int i = 0; i < questionCount; i++) {
            String[] qInfo = reader.readLine().split(" ");
            long K = Integer.parseInt(qInfo[0]);
            int startNode = Integer.parseInt(qInfo[1]);
            List<Integer> recommendNodes = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();


            queue.offer(startNode);
            visited[startNode] = 1;

            while (!queue.isEmpty()) {
                Integer nodeIndex = queue.poll();

                for (int j = 0; j < graph[nodeIndex].length; j++) {
                    if (visited[j] == 0 && graph[nodeIndex][j] >= K) {
                        recommendNodes.add(j);
                        queue.offer(j);
                        visited[j] = 1;
                    }
                }
            }

            writer.append(String.valueOf(recommendNodes.size()));
            writer.newLine();

        }


        writer.flush();
        writer.close();

    }
}
