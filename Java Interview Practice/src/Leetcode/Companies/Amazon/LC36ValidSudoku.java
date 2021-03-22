package src.Leetcode.Companies.Amazon;

public class LC36ValidSudoku {
    // UP - RIGHT - DOWN - LEFT
    private int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m < 1 || n < 1)
            return false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if ()
                }
            }
        }

    }

    private boolean checkValid(char[][] board, int i, int j, int rowLimit, int colLimit) {
        for (int r = 0; i < rowLimit; i++) {
            for (int c = 0; i < rowLimit; i++) {

            }
        }
    }

}
