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

    int wordIndx = 0;
    char[] charArr = word.toCharArray();
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] {0, 0});

    while (!q.isEmpty()) {
      int[] loc = q.poll();
      char curr = board[loc[0]][loc[1]];

      if (curr != charArr[wordIndx]) {
        for (int i = 0; i < dirs.length; i++) {

        }
      }

    }

    return false;
  }

}
