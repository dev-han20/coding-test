package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2933_fail {
	private static boolean[][] isVisited;
	private static int[] moveR = {-1, 0, 1, 0};
	private static int[] moveC = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] RC = reader.readLine().split(" ");

		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);

		String[][] cave = new String[R][C];

		for (int i = 0; i < R; i++) {
			String[] rowInfo = reader.readLine().split("");
			for (int j = 0; j < C; j++) {
				cave[i][j] = rowInfo[j];
			}
		}

		int attackCount = Integer.parseInt(reader.readLine());
		String[] attackHeight = reader.readLine().split(" ");
		int[] attackRowIndex = new int[attackCount];
		for (int i = 0; i < attackHeight.length; i++) {
			attackRowIndex[i] = R - Integer.parseInt(attackHeight[i]);
		}

		for (int i = 0; i < attackRowIndex.length; i++) {
			if (i % 2 == 0) {
				//좌에서 우로
				for (int j = 0; j < cave[attackRowIndex[i]].length; j++) {
					if (cave[attackRowIndex[i]][j].equals("x")) {
						cave[attackRowIndex[i]][j] = ".";
						break;
					}
				}
			} else {
				//우에서 좌로
				for (int j = cave[attackRowIndex[i]].length - 1; j >= 0; j--) {
					if (cave[attackRowIndex[i]][j].equals("x")) {
						cave[attackRowIndex[i]][j] = ".";
						break;
					}
				}
			}

			List<List<Location>> cluster = new ArrayList<>();
			Queue<Location> bq = new LinkedList<>();
			isVisited = new boolean[R][C];

			for (int j = 0; j < cave.length; j++) {
				for (int k = 0; k < cave[j].length; k++) {
					if (cave[j][k].equals("x") && !isVisited[j][k]) {
						bq.offer(new Location(j, k));
						isVisited[j][k] = true;

						cluster.add(new ArrayList<>());
						int clusterIndex = cluster.size() - 1;
						cluster.get(clusterIndex).add(new Location(j, k));

						while (!bq.isEmpty()) {
							Location location = bq.poll();

							for (int l = 0; l < 4; l++) {
								int nr = location.row + moveR[l];
								int nc = location.col + moveC[l];

								if (nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc] == true) {
									continue;
								}

								if (cave[nr][nc].equals("x")) {
									bq.offer(new Location(nr, nc));
									isVisited[nr][nc] = true;
									cluster.get(clusterIndex).add(new Location(nr, nc));
								}
							}
						}
					}
				}
			}

			// if (cluster.size() >= 2) {
				int overClusterIndex = -1;
				int overClusterRowIndex = Integer.MAX_VALUE;
				for (int j = 0; j < cluster.size(); j++) {
					List<Location> locations = cluster.get(j);
					Collections.sort(locations);
					if (!locations.isEmpty()) {
						if (overClusterRowIndex > locations.get(0).row) {
							overClusterRowIndex = locations.get(0).row;
							overClusterIndex = j;
						}
					}
				}

				boolean isDown = true;
				List<Location> overCluster = cluster.get(overClusterIndex);

				if (overClusterRowIndex == R - 1) {
					isDown = false;
				}

				while (isDown) {
					for (Location location : overCluster) {
						String s = cave[location.row][location.col];
						cave[location.row + 1][location.col] = s;
						cave[location.row][location.col] = ".";
						location.row++;
					}

					overClusterRowIndex = overCluster.get(0).row;

					for (Location location : overCluster) {
						if(overClusterRowIndex != location.row){
							break;
						}

						if (location.row + 1 >= R || cave[location.row + 1][location.col].equals("x")) {
							isDown = false;
							break;
						}
					}
				}
			}
		// }

		for (int i = 0; i < cave.length; i++) {
			for (int j = 0; j < cave[i].length; j++) {
				System.out.print(cave[i][j]);
			}
			System.out.println();
		}
	}

	private static class Location implements Comparable<Location> {
		private int row;
		private int col;

		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Location o) {
			if (o.row == this.row) {
				return this.col - o.col;
			}
			return o.row - this.row;
		}
	}

}
