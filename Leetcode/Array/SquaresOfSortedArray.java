import java.util.Arrays;

public class SquaresOfSortedArray {

    // Brute Force with Time: O(NlogN) - Space: O(1)
    public int[] sortedSquares(int[] A) {

        if (A.length < 1)
            return null;

        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }

        Arrays.sort(A);

        return A;
    }

    // Optimized version
    public int[] sortedSquaresOpt(int[] A) {

    }
}