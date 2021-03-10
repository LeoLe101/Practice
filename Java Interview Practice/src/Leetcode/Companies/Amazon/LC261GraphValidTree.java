package src.Leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC261GraphValidTree {

  // Space (N) - Time (N) WRONG ANSWER
  public boolean validTree(int n, int[][] edges) {
    List<List<Integer>> grid = new ArrayList<>();
    

    for (int i = 0; i < edges.length; i++) {

      for (int j = 0; i < edges[0].length; i++) {

      }

    }

  }

  private void dfs(int[][] edges) {

  }

  // Space (N) - Time (N) WRONG ANSWER
  // Note: This is not going to work for edges that are not connected together
  public boolean validTreeError(int n, int[][] edges) {
    Set<Integer> set = new HashSet<>();

    int temp = 0;
    for (int i = 0; i < edges.length; i++) {
      if (edges[i][0] > edges[i][1]) {
        temp = edges[i][0];
        edges[i][0] = edges[i][1];
        edges[i][1] = temp;
      }

      set.add(edges[i][0]);

      if (set.contains(edges[i][1]))
        return false;
      else
        set.add(edges[i][1]);
    }

    return true;

  }

}