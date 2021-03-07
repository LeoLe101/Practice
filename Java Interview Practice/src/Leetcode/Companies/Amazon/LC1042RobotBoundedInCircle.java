package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * LC1042RobotBoundedInCircle
 */
public class LC1042RobotBoundedInCircle {

    // Space (1) - Time (N)
    public boolean isRobotBounded(String instructions) {
        int[] pos = new int[] { 0, 0 };
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int x = 0, y = 0, i = 0, d[][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        int dir = 0; // 0: Up - 1: Right - 2: Down - 3: Left

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                pos[0] += dirs[dir][0];
                pos[1] += dirs[dir][1];
            } else if (c == 'L') {
                // This direction is an ordered direction from N-E-S-W
                // 0: North
                // 1: East 
                // 2: South 
                // 3: West
                // Since 
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        // Go back to where it started
        if (pos[0] == 0 && pos[1] == 0)
            return true;

        // Go to a direction heading North and not at the starting point (drifting away)
        if (dir == 0 && !(pos[0] == 0 && pos[1] == 0))
            return false;

        return true;
    }

    // #region Testing

    // Coordinate class
    private class Coordinate {
        public int x;
        public int y;

        public Coordinate() {
            this.x = 0;
            this.y = 0;
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Space (N) - Time (N)
    // This might not work because Coordinate Pos is 1 single variable in the Map
    // even if it changes the value, the mem allocated for this variable is still
    // the same in map
    // which means whenever it check if this pos is new or old, it is always old
    // (because only values changed and not the memory) so the map just think it is
    // already in map
    public boolean isRobotBoundedHashMapError(String instructions) {
        if (instructions.length() < 1)
            return false;

        char instruction = 0;

        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        int dir = 0; // 0: Up - 1: Right - 2: Left - 3: Down

        Coordinate pos = new Coordinate(0, 0);
        Map<Coordinate, Integer> map = new HashMap();
        map.put(pos, 1);

        for (int i = 0; i < instructions.length(); i++) {
            instruction = instructions.charAt(i);
            switch (instruction) {
            case 'G':
                // Move foward at curr direction
                pos.x += dirs[dir][0];
                pos.y += dirs[dir][1];
                break;
            case 'L':
                dir = (dir + 2) % 4;
                break;

            case 'R':
                dir = (dir + 1) % 4;
                break;
            default:
                break;
            }

            if (map.getOrDefault(pos, 0) < 1)
                map.put(pos, map.getOrDefault(pos, 0) + 1);
            else
                return true;
        }
        return false;
    }

    // #endregion Testing
}