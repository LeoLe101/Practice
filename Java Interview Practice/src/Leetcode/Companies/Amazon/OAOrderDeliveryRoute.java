import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OAOrderDeliveryRoute {

  private int[][] dirs = new int[][] { { 0, 1 }, // Up
      { 0, -1 }, // Down
      { 1, 0 }, // Right
      { -1, 0 } // Left
  };

  public int minimumDistance(List<List<Integer>> area) {
    int rowL = area.size();
    int colL = area.get(0).size();

    if (rowL < 1 || colL < 1) {
      return -1;
    }

    int res = 0;
    int[] start = new int[] { 0, 0 };
    Set<String> visited = new HashSet<>();
    Queue<int[]> q = new LinkedList<>();
    q.offer(start);
    visited.add(encoded(start));

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int[] coord = q.poll();

        if (area.get(coord[0]).get(coord[1]) == 9)
          return res;

        if (visited.contains(encoded(coord)))
          continue;
        visited.add(encoded(coord));

        for (int[] dir : dirs) {
          start[0] = coord[0] + dir[0];
          start[1] = coord[1] + dir[1];
          if (!isValidMove(rowL, colL, start, area))
            continue;
          q.offer(new int[] { start[0], start[1] });
        }
      }
      res++;
    }
    return -1;
  }

  private String encoded(int[] coord) {
    return "x:" + coord[0] + " - y:" + coord[1];
  }

  private boolean isValidMove(int rowL, int colL, int[] coord, List<List<Integer>> area) {
    if (coord[0] < 0 || coord[0] >= rowL || coord[1] < 0 || coord[1] >= colL || area.get(coord[0]).get(coord[1]) == 0)
      return false;

    return true;
  }

}
