package src.Leetcode.Array;

import java.util.LinkedList;

public class LC121BestTimeToBuySellStock {

    // public int maxProfit(int[] prices) {
    // int len = prices.length;
    // int result = -1;
    // int lowestPrice = Integer.MIN_VALUE;
    // if (len < 1) {
    // return result;
    // }
    // }

    /**
     * 
     * O-- -XT ---
     * 
     * @param cityMap
     * @return
     */
    public static int calculateDistance(String cityMap) {
        String[] inputArr = cityMap.split(";");
        int m = inputArr.length;
        int n = inputArr[0].length();

        char[][] map = new char[m][n];
        int[] from = new int[] { -1, -1 };
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, };

        for (int i = 0; i < inputArr.length; i++) {
            int j = 0;
            for (char c : inputArr[i].toCharArray()) {
                if (c == 'O') {
                    from[0] = i;
                    from[1] = j;
                }
                map[i][j] = c;
                j++;
            }
        }

        LinkedList<int[]> q = new LinkedList<>();
        q.addLast(from);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.pollFirst();
                map[cur[0]][cur[1]] = 'V';
                if (map[cur[0]][cur[1]] == 'T') {
                    return res;
                }
                for (int[] dir : dirs) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];

                    if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) {
                        continue;
                    }
                    if (map[newX][newY] != 'X' && map[newX][newY] != 'V') {
                        q.addLast(new int[] { newX, newY });
                    }
                }
            }
            res++;
        }
        return -1;
    }

    // if (cityMap.length() < 1)
    // return -1;

    // int len = cityMap.length();
    // char[][] graph = stringParser(cityMap);
    // Queue<Character> q = new LinkedList<>();

    private static char[][] stringParser(String input) {
        String[] result = input.split(";");
        char[][] arr = new char[input.length()][input.length()];
        // Create 2D array with all char inside
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i].toCharArray();
        }
        return arr;
    }

    public static void main(String[] args) {
        String input = "O__;_XT;___";
        System.out.println(calculateDistance(input));
    }

}
