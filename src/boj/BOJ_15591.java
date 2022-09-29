package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_15591 {
    static int nodeCount;
    static int questionCount;
    static List<List<Info>> graph;
    static int[] visited;

    private static class Info{
        private int nodeIndex;
        private long USADO;

        public Info(int nodeIndex, long USADO) {
            this.nodeIndex = nodeIndex;
            this.USADO = USADO;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RC = reader.readLine().split(" ");

        nodeCount = Integer.parseInt(RC[0]);
        questionCount = Integer.parseInt(RC[1]);
        graph = new ArrayList<>();
        for (int i = 0; i < nodeCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            String[] nodeInfo = reader.readLine().split(" ");
            int nodeIndex = Integer.parseInt(nodeInfo[0]);
            int otherNodeIndex = Integer.parseInt(nodeInfo[1]);
            long USADO = Long.parseLong(nodeInfo[2]);

            graph.get(nodeIndex).add(new Info(otherNodeIndex, USADO));
            graph.get(otherNodeIndex).add(new Info(nodeIndex, USADO));
        }

        for (int i = 0; i < questionCount; i++) {
            String[] qInfo = reader.readLine().split(" ");
            long K = Long.parseLong(qInfo[0]);
            int startNode = Integer.parseInt(qInfo[1]);
            List<Integer> recommendNodes = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            visited = new int[nodeCount + 1];

            queue.offer(startNode);
            visited[startNode] = 1;

            while (!queue.isEmpty()) {
                Integer nodeIndex = queue.poll();

                for (int j = 0; j < graph.get(nodeIndex).size(); j++) {
                    Info info = graph.get(nodeIndex).get(j);
                    if (info.USADO < K) {
                        continue;
                    }

                    if (visited[info.nodeIndex] == 0 && info.USADO >= K) {
                        recommendNodes.add(info.nodeIndex);
                        queue.offer(info.nodeIndex);
                        visited[info.nodeIndex] = 1;
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
