package src.Leetcode.Companies.Amazon;

import java.util.HashSet;
import java.util.Set;

public class LC36ValidSudoku {

    /**
     * Space (N * M) - Need only 1 hashset to keep all cell in the board
     * Time (N * M) - With N is the row length and M is the col length
     */
    public boolean isValidSudokuEncoded(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m < 1 || n < 1)
            return false;

        Set<String> s = new HashSet<>();
        // Go through 9 sub-boxes
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currChar = board[i][j];

                // Skip empty cell
                if (currChar == '.')
                    continue;

                // Mapping the row, col, sub-box of curr number
                String currRow = currChar + " in row [" + i + "]";
                String currCol = currChar + " in box [" + j + "]";
                String currSubBox = currChar + " in box [" + i/3 + ", " + j/3 + "]";

                // If cannot add into set means that it's already in the set
                if (!s.add(currRow) || !s.add(currCol) || !s.add(currSubBox))
                    return false;
            }
        }
        return true;
    }

    /**
     * Space (N) or maybe (1) since we already know that we will need 2 2D matrices
     * and a 3D matrix for mapping the sudoku
     * 
     * Time (N * M) with N is the row length and M is the col length
     */
    public boolean isValidSudokuMapping(char[][] board) {
        // 2D arr of all 9 row/col and 9 number values within the row/col
        // 1D: row/col index - 2D: number value
        boolean[][] rowMap = new boolean[9][9];
        boolean[][] colMap = new boolean[9][9];

        // 3x3 sub-boxes mapping
        // 1D: row index - 2D: col index - 3D: number value
        boolean[][][] boxMap = new boolean[3][3][9];

        int currNumb = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                currNumb = board[i][j] - '0' - 1;

                // Skip empty cell
                if (board[i][j] == '.')
                    continue;

                // Check if exist in this row or col
                if (rowMap[i][currNumb] || colMap[j][currNumb]) {
                    return false;
                }

                // Check if exist in 3x3 sub-box
                if (boxMap[i / 3][j / 3][currNumb]) {
                    return false;
                }

                // Mark this number visited for whole row, col, and 3x3 box
                rowMap[i][currNumb] = true;
                colMap[j][currNumb] = true;
                boxMap[i / 3][j / 3][currNumb] = true;
            }
        }
        return true;
    }

}