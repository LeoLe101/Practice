package src.Leetcode.Problems;

public class LC209MinimumSizeSubarraySum {
    
    // Space(1) Time (N)
    public int minSubArrayLen(int S, int[] arr) {
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
}
