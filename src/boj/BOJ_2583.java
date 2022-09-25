package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2583 {
	private static int[][] grid;
	private static int rowCount;
	private static int colCount;
	private static int squareCount;
	private static int[] moveRow = {-1, 0, 1, 0};
	private static int[] moveCol = {0, 1, 0, -1};
	private static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] MNK = reader.readLine().split(" ");
		rowCount = Integer.parseInt(MNK[0]);
		colCount = Integer.parseInt(MNK[1]);
		squareCount = Integer.parseInt(MNK[2]);

		grid = new int[rowCount][colCount];

		for (int i = 0; i < squareCount; i++) {
			String[] squareInfo = reader.readLine().split(" ");
			squareCheck(squareInfo);
		}

		Queue<Cell> cells = new LinkedList<>();

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if (grid[i][j] == 0) {
					cells.add(new Cell(i, j));
					grid[i][j] = 1;
					int result = 0;

					while (!cells.isEmpty()) {
						Cell cell = cells.poll();
						result++;

						for (int k = 0; k < 4; k++) {
							int nextRow = cell.rowIndex + moveRow[k];
							int nextCol = cell.colIndex + moveCol[k];

							if (nextRow < 0 || nextCol < 0 || nextRow >= rowCount || nextCol >= colCount) {
								continue;
							}

							if (grid[nextRow][nextCol] == 1) {
								continue;
							}

							cells.add(new Cell(nextRow, nextCol));
							grid[nextRow][nextCol] = 1;
						}
					}
					results.add(result);
				}
			}
		}

		results.sort(Comparator.naturalOrder());

		System.out.println(results.size());
		for (Integer result : results) {
			System.out.print(result + " ");
		}
		
	}

	private static void squareCheck(String[] squareInfo) {
		int leftSquareCol = Integer.parseInt(squareInfo[0]);
		int leftSquareRow = (rowCount - 1) - Integer.parseInt(squareInfo[1]);
		int rightSquareCol = Integer.parseInt(squareInfo[2]) - 1;
		int rightSquareRow = (rowCount - 1) - (Integer.parseInt(squareInfo[3]) - 1);

		// grid[leftSquareRow][leftSquareCol] = 1;
		// grid[rightSquareRow][rightSquareCol] = 1;

		for (int i = rightSquareRow; i <= leftSquareRow; i++) {
			for (int j = leftSquareCol; j <= rightSquareCol; j++) {
				grid[i][j] = 1;
			}
		}
	}

	private static class Cell {
		private int rowIndex;
		private int colIndex;

		public Cell(int rowIndex, int colIndex) {
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}
	}


}
