package src.Educative;

import src.Util.ListNode;

public class SlidingWindow {

    // #region Maxiumum Sum Subarray of Size K: Space (1) Time (N)
    /**
     * Given an array of positive numbers and a positive number ‘k,’ find the
     * maximum sum of any contiguous subarray of size ‘k’.
     * 
     * @param k   Range to find the Max Sum Subarray
     * @param arr Array given
     * @return The max Sum Subarray
     */
    public int findMaxSumSubArray(int k, int[] arr) {
        int result = -1;
        int fastPtr = k - 1;
        int sum = 0;
        int counter = 0;

        // Move the SlowPtr until meet the FastPtr, then increment the FastPtr by 1 and
        // and check sum, then restart the SlowPtr to the counter
        for (int slowPtr = 0; slowPtr < arr.length; slowPtr++) {
            sum += arr[slowPtr];

            if (slowPtr == fastPtr) {
                result = Math.max(sum, result);
                sum -= arr[counter];
                counter++;
                fastPtr++;
            }
        }
        return result;
    }

    public int findMaxSumSubArrayEdu(int k, int[] arr) {
        int windowSum = 0, maxSum = 0, windowStart = 0;

        // Move the windowEnd until it is more than K range,
        // then increase windowStart by 1 and check sum
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window
            // size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
    // #endregion

    // #region Smallest Subarray with a given sum: Space (1) Time (N * K) where N
    // size the array iteration through each element and K is the Window Size
    /**
     * Given an array of positive numbers and a positive number ‘S,’ find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0 if no such subarray exists.
     * 
     * @param s   Target for the sum to compare with
     * @param arr Array given
     * @return Smallest subarray size whose sum is > || = to given S number
     */
    // REVIEW Not all edge cases are covered with this solution
    // Space (1) Time (N*K)
    public int findMinSubArrayError(int s, int[] arr) {
        int sum = 0, slowPtr = 0, len = arr.length, windowSize = 1;
        while (windowSize < len) {
            // Find the largest Sum is greater or equal to target s
            for (int fastPtr = 0; fastPtr < len; fastPtr++) {
                sum += arr[fastPtr];
                if (fastPtr + 1 >= windowSize) {
                    if (sum >= s)
                        return windowSize;
                    sum -= arr[slowPtr];
                    slowPtr++;
                }
            }
            // Reset slowPtr and increase windowSize
            slowPtr = 0;
            windowSize++;
        }
        return 0;
    }

    // Space (N) Time (N^2)
    public int BF_findMinSubArray(int s, int[] arr) {
        int sum = 0, result = Integer.MAX_VALUE;
        for (int slowPtr = 0; slowPtr < arr.length; slowPtr++) {

            for (int fastPtr = slowPtr; fastPtr < arr.length; fastPtr++) {
                sum += arr[fastPtr];
                if (sum >= s) {
                    result = Math.min(result, sum);
                    break;
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : 0; // If Max, return 0 instead
    }

    // Space (1) Time (N)
    public int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        // Loop through the window to find number > 'S'
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            // if the sum is more than 'S',
            // Shrink windowSize until the 'windowSum' < 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // remove the first element
                windowStart++; // move window up
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength; // If Max, return 0 instead
    }

    // #endregion

    // #region Find the average of all contiguous subarrays of size ‘5’ in the given
    // array.
    // Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    // Output: [2.2, 2.8, 2.4, 3.6, 2.8]
    public double[] BF_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1]; // Since the window is always K size
        double sum = 0.0;
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = 0; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    // Optimization: Save the calculated common areas within the array by minus the
    // first and add the last elmnt
    public double[] OPT_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double sum = 0.0;
        int windowStart = 0;

        // First calculation
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // Starting optimization calculation
        for (int j = 0; j < result.length; j++) {
            if (j > 0) {
                sum = sum - arr[windowStart] + arr[j + k - 1];
            }
            result[j] = sum / k;
            windowStart = j;
        }
        return result;
    }

    // #endregion

    // #region 
    
    
    // //#endregion
}