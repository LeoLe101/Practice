package src.Edu.SlidingWindow;

public class MaximumSumSubarraySizeK {

    /**
     * Input: [2, 1, 5, 1, 3, 2], k=3 
     * Output: 9 
     * Explanation: Subarray with maximum sum is [5, 1, 3].
     */
    public int findMaxSumSubArray(int k, int [] arr) {
        int result = -1;
        int len = arr.length;
        if (len < 1)
            return result;

        int sum = 0;
        int i = 0;
        while (i < len - 1) {
            sum += arr[i];
            if (i >= k - 1) {
                result = Math.max(result, sum);
                sum -= arr[i];
            }
        }
        return result;
    }
}
