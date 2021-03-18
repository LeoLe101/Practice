package src.Leetcode.Companies.Amazon;

public class LC79WordSearch {

  // UP - RIGHT - DOWN - LEFT (x, y)
  private int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (word.charAt(0) == board[i][j] && dfs(board, visited, word, i, j, 0))
          return true;
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int wordIndex) {

    // All word founded! and index already move pass word.len
    if (wordIndex == word.length())
      return true;

    // If out of bound or word not what we are looking for or already visited, pop
    // false
    if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j]
        || board[i][j] != word.charAt(wordIndex))
      return false;

    // mark as visited for traversal
    visited[i][j] = true;

    // This char is the same with word search, move on to next 4
    for (int[] dir : dirs) {
      if (dfs(board, visited, word, i + dir[0], j + dir[1], wordIndex + 1))
        return true;
    }

    // If none of the 4 dirs is the next char, make this char unvisited to traverse
    // again
    // NOTE: This will not be needed if line 29 use a new boolean[][] everytime
    visited[i][j] = false;

    return false;
  }
}
