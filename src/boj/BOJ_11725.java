package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11725 {
    private static int[] nodes;
    private static List<List<Integer>> graph;
    private static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        nodes = new int[N + 1];
        visited = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int node = Integer.parseInt(edgeInfo[0]);
            int otherNode = Integer.parseInt(edgeInfo[1]);
            graph.get(node).add(otherNode);
            graph.get(otherNode).add(node);
        }

        DFS(1);

        for (int i = 2; i < nodes.length; i++) {
            System.out.println(nodes[i]);
        }

    }

    private static void DFS(int parentNodeIndex) {
        visited[parentNodeIndex] = 1;
        for (Integer nodeIndex : graph.get(parentNodeIndex)) {
            if (visited[nodeIndex] == 1) {
                continue;
            }
            nodes[nodeIndex] = parentNodeIndex;
            DFS(nodeIndex);
        }
    }
}
