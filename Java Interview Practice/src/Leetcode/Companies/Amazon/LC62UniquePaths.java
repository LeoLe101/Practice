package src.Leetcode.Companies.Amazon;

public class LC62UniquePaths {

  // Space (N * M) because we need to keep track all the vals in each cell of the
  // grid
  // Time (N * M) because of the grid size that we have to traverse each grid cell
  // N is row and M is col
  // Dynamic Programming where we calculate the direction that the robot can move
  // thru to get to this current cell
  // - This makes all row[0] and col[0] value = 1 due to it can only go from the
  // right or top down.
  // - Once we have these values set for these cell, traverse all the grid cell
  // within row[1] -> row[n] and col[1] -> col[n]
  // - Calculate the path of this current grid[i][j] with previous direction value
  // from previous top and left cell
  public int uniquePaths(int m, int n) {

    // Initialize DP array to hold value calculated
    int[][] dp = new int[m][n];

    // Init val for row[0] -> row[m] (1st top down col)
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    // Init val for col[0] -> col[n] (1st left right row)
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    // Traverse all grid cell from 1 -> m or n and calculate this cell with prev
    // left and top cell's val
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    // Return the last bottom right val from the grid
    return dp[m - 1][n - 1];
  }

  /**
   * Space (N * M): Hold all val in grid and back tracking stack from recursion
   * Time (N * M): traverse all cell and back track NOTE: THIS IS NOT CORRECT
   */
  public int uniquePathsDFS(int m, int n) {
    return uniquePathsHelper(m, n, 0, 0, new int[m][n]);
  }

  public int uniquePathsHelper(int m, int n, int row, int col, int[][] memo) {
    // out of bound
    if (row >= m || col >= n) {
      return 0;
    }

    // got prev cal
    if (memo[row][col] != 0) {
      return memo[row][col];
    }

    // hit the end of the grid
    if (m - 1 == row && n - 1 == col) {
      return 1;
    }

    // calculation of all rows back till curr
    int rowCount = uniquePathsHelper(m, n, row + 1, col, memo);
    // calculation of all cols back till curr
    int colCount = uniquePathsHelper(m, n, row, col + 1, memo);
    // cal path and memoize it
    memo[row][col] = rowCount + colCount;
    return memo[row][col];
  }
}
