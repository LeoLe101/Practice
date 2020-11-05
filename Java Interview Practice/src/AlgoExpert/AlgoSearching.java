package src.AlgoExpert;

/**
 * AlgoSearching
 */
public class AlgoSearching {

    // Recursion
    // Space: O(1) but can be O(log N) in some language because of the recursion
    // stack
    // Time: O(N) because it split the array by half every iteration
    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    public static int binarySearchHelper(int[] array, int target, int startindx, int endindx) {
        int midindx = startindx + (endindx - startindx) / 2;

        if (startindx > endindx)
            return -1;

        if (array[midindx] == target) {
            return midindx;
        } else if (array[midindx] < target) {
            return binarySearchHelper(array, target, midindx + 1, endindx);
        } else {
            return binarySearchHelper(array, target, startindx, midindx - 1);
        }
    }

    // Time (N) - Space (1)
    public static int[] findThreeLargestNumbers(int[] array) {
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int num3 = Integer.MIN_VALUE;

        for (int num : array) {
            if (num >= num3) {
                num1 = num2;
                num2 = num3;
                num3 = num;
            } else if (num >= num2 && num < num3) {
                num1 = num2;
                num2 = num;
            } else if (num >= num1 && num < num2) {
                num1 = num;
            }
        }
        return new int[] { num1, num2, num3 };
    }

    // This solution use Binary Search to help find the location of the target
    // Not good solution Time (N LOGN) - Space (N) Due to Binary recursion stack
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        int[] result = new int[] { -1, -1 };

        for (int i = 0; i < matrix.length; i++) {
            int index = binarySearch(matrix[i], target);
            if (index > -1) {
                result[0] = i;
                result[1] = index;
                break;
            }
        }
        return result;
    }

    // Move from the Top Right to the Bottom Left of the Matrix
    // Constantly shift row and col accordingly to check if the current is the
    // target
    // Sapce (1) - Time (N + M) with N is the number of the whole row. M is the
    // number of the whole col
    public static int[] searchInSortedMatrixOptimized(int[][] matrix, int target) {
        int col = 0;
        int row = matrix[col].length - 1;

        while (row > -1 && col < matrix.length) {
            int curr = matrix[col][row];
            if (curr == target) {
                return new int[] { col, row };
            } else if (curr > target) {
                row--;
            } else {
                col++;
            }
        }
        return new int[] { -1, -1 };
    }

}