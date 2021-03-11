package src.Leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC261GraphValidTree {

  // Space (N + E) - Time (N + E) - with N: Number of nodes/vertices and E: Number of edges
  // Graph traversal using DFS
  public boolean validTreeDFS(int n, int[][] edges) {
    boolean visited[] = new boolean[n];
    List<List<Integer>> adjList = new ArrayList<>();
    // Map<Integer, int[]> adjMap = new HashMap<>(); // can be use instead of the 1
    // above

    // Init the Matrix 
    // O (N) - Depend on node amount
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<Integer>());
    }

    // Hold the current vertex and an array of all the vertices connected to this.
    // And vice versa between U and V
    // O (E) - Depend of Edges amount
    for (int i = 0; i < edges.length; i++) {
      adjList.get(edges[i][0]).add(edges[i][1]);
      adjList.get(edges[i][1]).add(edges[i][0]);
    }

    // Check if graph has a Cylce
    if (dfsHasCycle(adjList, visited, 0, -1)) {
      return false;
    }

    for (boolean visit : visited)
      if (!visit)
        return false;

    return edges.length < n - 1 ? false : true;
  }

  // DFS down to each node about to visit and check if it's visited
  private boolean dfsHasCycle(List<List<Integer>> adjList, boolean[] visisted, int vertex, int prevVertex) {
    visisted[vertex] = true;

    // Get the next vertices connected to this vertex
    for (Integer nextVertex : adjList.get(vertex)) {
      // Duplication between previous layer iteration of 2d Matrix and curr
      if (nextVertex == prevVertex) {
        continue;
      }

      // Has a Cycle while traversal
      if (visisted[nextVertex])
        return true;

      // DFS Check if the next vertex has a cycle
      if (dfsHasCycle(adjList, visisted, nextVertex, vertex))
        return true;
    }

    return false; // Graph doesn't have cycle
  }

  // Space (N) - Time (N) WRONG ANSWER
  // Note: This is not going to work for edges that are not connected together
  public boolean validTreeError(int n, int[][] edges) {
    Set<Integer> visitedSet = new HashSet<>();

    int temp = 0;

    // Loop through the edges arr
    for (int i = 0; i < edges.length; i++) {

      // Swap the smaller val as node and bigger val as vertice
      if (edges[i][0] > edges[i][1]) {
        temp = edges[i][0];
        edges[i][0] = edges[i][1];
        edges[i][1] = temp;
      }

      // Always add node/u to set
      visitedSet.add(edges[i][0]);

      // Check if the vertice is visited or not
      if (visitedSet.contains(edges[i][1]))
        return false;
      else
        visitedSet.add(edges[i][1]);
    }

    return true;
  }

}