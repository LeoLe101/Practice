package src.Leetcode.Problems;

public class LC53MaximumSubarray {

    // Space(1) Time(N)
    // https://www.youtube.com/watch?v=gwUGDXO5gHU&ab_channel=TerribleWhiteboard
    // Watch that video to understand better
    /**
     * Trace of what actually happened
     * [-2,1,-3,4,-1,2,1,-5,4] MEH = -2 MSF = -2
     * 
     * MEH = Max(-2+1,1) = 1 MSF = Max(-2, 1) = 1
     * 
     * MEH = Max(1-3,-3) = -2 MSF = Max(1, -2) = 1
     * 
     * MEH = Max(-2+4, 4) = 4 MSF = Max(1, 4) = 4
     * 
     * MEH = Max(4-1,-1) = 3 MSF = Max(4, 3) = 4
     * 
     * MEH = Max(3+2,2) = 5 MSF = Max(4, 5) = 5
     * 
     * MEH = Max(5+1,1) = 6 MSF = Max(5,6) = 6
     * 
     * MEH = Max(6-5, -5) = 1 MSF = Max(6, 1) = 6
     * 
     * MEH = Max(1+4, 4) = 4 MSF = Max(6, 4) = 6
     * 
     * @param A
     * @return
     */
    public int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];

        for (int i = 1; i < A.length; ++i) {
            // Choose the max out of the next number only or the sum of this number and the
            // next number
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);

            // Choose the max out of current Max we already have or the Max we have from
            // previous comparison
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArrayAnother(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // Check if the curr Sum < 0, if it is, take the curr number because the
            sum = sum < 0 ? nums[i] : (sum + nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

    

}
