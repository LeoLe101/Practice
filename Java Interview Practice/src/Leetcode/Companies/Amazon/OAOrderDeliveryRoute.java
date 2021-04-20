package src.Leetcode.Companies.Amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OAOrderDeliveryRoute {

    private int[][] dirs = new int[][] { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };

    /**
     * Similar to the Demolition Robot questions
     * Time (M * N)
     * Space (M * N)
     */
    public int minimumDistance(List<List<Integer>> area) {
        int aSize = area.size();
        int innerASize = area.get(0).size();
        if (aSize < 1 || innerASize < 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        Set<String> visited = new HashSet<>();
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (area.get(cur[0]).get(cur[1]) == 9)
                    return res;

                if (visited.contains(encode(cur[0], cur[1])))
                    continue;
                visited.add(encode(cur[0], cur[1]));
                
                for (int j = 0; j < 4; j++) {
                    int newx = cur[0] + dirs[j][0];
                    int newy = cur[1] + dirs[j][1];
                    if (!isValid(newx, newy, aSize, innerASize, area))
                        continue;
                    q.offer(new int[] { newx, newy });
                }
            }
            res++;
        }
        return -1;
    }

    public boolean isValid(int x, int y, int m, int n, List<List<Integer>> area) {
        return x >= 0 && x < m && y >= 0 && y < n && area.get(x).get(y) != 0;
    }

    public String encode(int x, int y) {
        return "(" + x + "," + y + ")";
    }
}

/**
 * In order to traverse through all the map, we will need the coordinate for 4 different directions. We init this as dirs array
 * Because we are finding the minimum distance to the delivery location, we will need to use Breadth First Search with a Queue of locations to traverse throught the matrix.
 * We will have a Set to hold all the encoded location we have visited (as String format) while traversing the matrix, so we do not have to repeat that move again.
 * 
 * First, we start at top left location with location (0, 0) and put it into our Queue of locations.
 * Then if the Queue is not empty, 
 *  - Depending on the size of the current Queue, Pop the location coordinate out of the Queue to traverse all the adjacent location coordinates.
 *    - Check if the current location is the delivery location. If it is, return the number of steps traversed.
 *    - Check if we traversed through this cell yet. If we did, skip it this cell.
 *    - Start traverse through 4 different directions (Up, Down, Right, Left).
 *       - Check if the coordinate of this direction is valid to move (out of bound or obstacles coordinate '0'). If it is not valid, skip this coordinate.
 *       - Put the valid coordinate to the Queue of locations for next iterations.
 *  - After finished traversing all adjacent location, increase the result distance for record.
 * 
 * After going through the whole matrix area, if we cannot find delivery location '9', return -1 as not found.
 * 
 * Space: O(N) Because of the Queue and Set needed for tracking the location
 * Time:  O(N * M) with N is the amount of row and M is the amount of column in the area matrix that we will need to go through.
 * 
 */