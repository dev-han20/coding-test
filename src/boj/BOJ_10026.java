package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] moveRow = {-1, 0, 1, 0};
    private static int[] moveCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int normal = 0;
        int unNormal = 0;


        GraphDto[][] normalGraph = new GraphDto[N][N];
        GraphDto[][] unNormalGraph = new GraphDto[N][N];

        for (int i = 0; i < N; i++) {
            String[] rowInfo = reader.readLine().split("");
            for (int j = 0; j < N; j++) {
                normalGraph[i][j] = new GraphDto(rowInfo[j], i, j);
                unNormalGraph[i][j] = new GraphDto(rowInfo[j], i, j);
            }
        }

        Queue<GraphDto> BFSList = new LinkedList<>();

        for (int i = 0; i < normalGraph.length; i++) {
            for (int j = 0; j < normalGraph[i].length; j++) {
                if (normalGraph[i][j].visited) {
                    continue;
                }
                normalGraph[i][j].visited = true;
                BFSList.offer(normalGraph[i][j]);


                while (!BFSList.isEmpty()) {
                    GraphDto graphDto = BFSList.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextRow = graphDto.row + moveRow[k];
                        int nextCol = graphDto.col + moveCol[k];

                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                            continue;
                        }

                        if (normalGraph[nextRow][nextCol].visited) {
                            continue;
                        }

                        if (graphDto.value.equals(normalGraph[nextRow][nextCol].value)) {
                            normalGraph[nextRow][nextCol].visited = true;
                            BFSList.offer(normalGraph[nextRow][nextCol]);
                        }
                    }
                }
                normal++;

            }
        }

        BFSList.clear();

        for (int i = 0; i < unNormalGraph.length; i++) {
            for (int j = 0; j < unNormalGraph[i].length; j++) {
                if (unNormalGraph[i][j].visited) {
                    continue;
                }
                unNormalGraph[i][j].visited = true;
                BFSList.offer(unNormalGraph[i][j]);


                while (!BFSList.isEmpty()) {
                    GraphDto graphDto = BFSList.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextRow = graphDto.row + moveRow[k];
                        int nextCol = graphDto.col + moveCol[k];

                        if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                            continue;
                        }

                        if (unNormalGraph[nextRow][nextCol].visited) {
                            continue;
                        }

                        if (graphDto.value.equals(unNormalGraph[nextRow][nextCol].value)) {
                            unNormalGraph[nextRow][nextCol].visited = true;
                            BFSList.offer(unNormalGraph[nextRow][nextCol]);
                        }

                        if (graphDto.value.equals("R") && unNormalGraph[nextRow][nextCol].value.equals("G")) {
                            unNormalGraph[nextRow][nextCol].visited = true;
                            BFSList.offer(unNormalGraph[nextRow][nextCol]);
                        }

                        if (graphDto.value.equals("G") && unNormalGraph[nextRow][nextCol].value.equals("R")) {
                            unNormalGraph[nextRow][nextCol].visited = true;
                            BFSList.offer(unNormalGraph[nextRow][nextCol]);
                        }
                    }
                }
                unNormal++;
            }
        }

        System.out.println(normal + " " + unNormal);

    }

    private static class GraphDto {
        String value;
        int row;
        int col;
        boolean visited;

        public GraphDto(String value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
            visited = false;
        }
    }

}
