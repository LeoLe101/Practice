package src.Leetcode.Companies.Amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OADemolitionRobot {

  /**
   * Given a matrix with values 0 (trenches) , 1 (flat) , and 9 (obstacle.
   * 
   * You have to find minimum distance to reach 9 (obstacle). If not possible then
   * return -1. The demolition robot must start at the top left corner of the
   * matrix, which is always flat, and can move on block up, down, right, left.
   * 
   * The demolition robot cannot enter 0 trenches and cannot leave the matrix.
   * 
   * Ex: - Input : [1, 0, 0], [1, 0, 0], [1, 9, 1]] - Output : 3
   */

  // Space (N * M) - Time (N * M)
  public int distanceTraversed(List<List<Integer>> lot) {

  }

  // hint: Treat coordinate as TreeNode like previous assignment
  private int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

  // Space (N * M) - Time (N * M)
  private int minimumPath(int[][] grid) {
    if (grid.length < 1 || grid[0].length < 1)
      return -1;
    int result = -1;

    // start from(0, 0), perform BFS
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { 0, 0 });
    Set<String> visited = new HashSet<>();
    int res = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        if (grid[cur[0]][cur[1]] == 9)
          return res;
        if (visited.contains(encode(cur[0], cur[1])))
          continue;
        visited.add(encode(cur[0], cur[1]));
        for (int j = 0; j < 3; j++) {
          int newx = cur[0] + dirs[j][0];
          int newy = cur[1] + dirs[j][1];
          if (!isValid(newx, newy))
            continue;
          q.offer(new int[] { newx, newy });
        }
      }
      res++;
    }
    return -1;
  }

  public boolean isValid(int x, int y, int m, int n) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }

  public String encode(int x, int y) {
    return "(" + x + "," + y + ")";
  }

}
