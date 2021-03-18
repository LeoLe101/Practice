package src.Leetcode.Companies.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class LC79WordSearch {

  // UP - RIGHT - DOWN - LEFT (x, y)
  private int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  /**
   * Space (N * M) - because board Time (N * M) - Because traverse all cell in
   * board
   */
  public boolean exist(char[][] board, String word) {
    if (word.length() < 1 || board.length < 1 || board[0].length < 1)
      return false;

    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (dfs())
          return true;
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int wordIndex) {

  }
}
