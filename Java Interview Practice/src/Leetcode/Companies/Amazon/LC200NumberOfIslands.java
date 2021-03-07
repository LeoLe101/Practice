package src.Leetcode.Companies.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class LC200NumberOfIslands {

	private int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	// Space (N) Time (N * M) due to loop Row i and Col j of grid
	public int numIslands(char[][] grid) {
		int lenRow = grid.length;
		int lenCol = grid[0].length;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int numberIsland = 0;
		for (int i = 0; i < lenRow; i++) {
			for (int j = 0; j < lenCol; j++) {
				// Traverse all adjacents from this cell (up, down, left, right)
				bfs(grid, i, j, visited);
				// Increase number of island since all adj cell of curr cell are marked as
				// visited
				numberIsland++;
			}
		}
		return numberIsland;
	}

	private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
		int m = grid[0].length;
		int n = grid.length;
		// Instead of having Queue hold an array, which will create more Space
		// We use encoded calculation: encodedPos = rowLocation * rowLength +
		// colLocation
		// When need rowLocation = encodedPos / rowLength
		// When need colLocation = encodedPos % rowLength
		int encodedPos = grid[i][j] * m + j;

		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(encodedPos);

		while (!q.isEmpty()) {
			int currLoc = q.poll();
			// Decode Position
			int currI = currLoc / m;
			int currJ = currLoc % m;

			// Move 4 directions (shorter way to travers compare to 4 if statements above)
			for (int[] dir : dirs) {
				currI += dir[0];
				currJ += dir[1];

				// when the current cell run out of bound
				if (!visited[currI][currJ] || grid[currI][currJ] == '0' || currI < 0 || currI >= n || currJ < 0
						|| currJ >= m)
					continue;

				visited[currI][currJ] = true;
				q.offer(grid[currI][currJ] * m + currJ);
			}
		}
	}

	// #region DFS with Stack/Recursion

	// Space (N) - Time (N * M) with N is amount of element in grid[0] (ROW) and M
	// is amount of element in grid [0][0] (COL)
	// DFS will change the grid's values
	public int numIslandsDFS(char[][] grid) {
		int result = 0;
		// Traverse each element in grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// Perform dfs traversal and change current island to water (1 -> 0) only if
				// this location is land
				if (grid[i][j] == '1') {
					dfsTest(grid, i, j);

					// Everytime finished counting all the island from this curr location, increase
					// island count
					result++;
				}
			}
		}
		return result;
	}

	private void dfsTest(char[][] grid, int i, int j) {
		// Pop/Return if curr location is not an island or out of bound
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}

		// Change island to water (1 -> 0) for later backtrack
		grid[i][j] = '0';

		// Move and test 4 dif dirs from curr location
		dfsTest(grid, i + 1, j);
		dfsTest(grid, i - 1, j);
		dfsTest(grid, i, j + 1);
		dfsTest(grid, i, j - 1);
	}

	// #endregion

}
