package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2638 {
    private static int[] moveRow = {-1, 0, 1, 0};
    private static int[] moveCol = {0, 1, 0, -1};
    private static List<Location> meltList = new ArrayList<>();
    private static int time = 0;
    private static boolean repeat = true;
    private static Queue<Location> queue = new LinkedList<>();
    private static int[][] grid;
    private static int[][] visited;
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        grid = new int[N][M];

        for (int i = 0; i < grid.length; i++) {
            String[] rowInfo = reader.readLine().split(" ");
            for (int j = 0; j < rowInfo.length; j++) {
                grid[i][j] = Integer.parseInt(rowInfo[j]);
            }
        }



//        meltListCheck();


        while (repeat) {
            outsideCheck();
            insideCheck();

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        int emptyCount = 0;
                        int nextRow = 0;
                        int nextCol = 0;
                        for (int k = 0; k < 4; k++) {
                            nextRow = i + moveRow[k];
                            nextCol = j + moveCol[k];

                            if (grid[nextRow][nextCol] == 0) {
                                emptyCount++;
                            }
                        }

                        if (emptyCount >= 2) {
                            meltList.add(new Location(i, j));
                        }
                    }
                }
            }

            if (meltList.isEmpty()) {
                break;
            } else {
                for (Location location : meltList) {
                    grid[location.rowIndex][location.colIndex] = 0;
                }
                meltList.clear();
                time++;
            }

            insideMarkRollback();
        }
        System.out.println(time);

    }

    private static void insideMarkRollback() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                }
            }
        }
    }


    private static void insideCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    grid[i][j] = 2;
                }
            }
        }
    }

    private static void outsideCheck() {
        visited = new int[N][M];
        queue.offer(new Location(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Location location = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nextRow = location.rowIndex + moveRow[k];
                int nextCol = location.colIndex + moveCol[k];

                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }

                if (visited[nextRow][nextCol] == 1) {
                    continue;
                }

                if (grid[nextRow][nextCol] == 0) {
                    queue.offer(new Location(nextRow, nextCol));
                    visited[nextRow][nextCol] = 1;
                }
            }
        }
    }

    private static class Location {
        private int rowIndex;
        private int colIndex;

        public Location(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }




}
