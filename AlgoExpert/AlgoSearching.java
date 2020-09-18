import java.util.*;

/**
 * AlgoSearching
 */
public class AlgoSearching {

    // Recursion
    // Space: O(1) but can be O(log N) in some language because of the recursion stack
    // Time: O(N) because it split the array by half every iteration
    public int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, target, 0, array.length - 1);
    }

    public int binarySearchHelper(int[] array, int target, int startindx, int endindx) {
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

}