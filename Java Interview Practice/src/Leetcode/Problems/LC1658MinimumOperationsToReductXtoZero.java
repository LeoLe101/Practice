package src.Leetcode.Problems;

public class LC1658MinimumOperationsToReductXtoZero {

    // Space (1) - Time (N)
    public int minOperations(int[] nums, int x) {

        int maxSub = -1;
        int total = 0;
        int sum = 0;
        int left = 0;

        // Find Total of whole array
        for (int num : nums) {
            total += num;
        }

        // Target to find the max subarray in the middle = target
        int target = total - x;

        // Sliding window, find the maxsub array equal to target
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Reduce from left side to <= target
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            // If equal target, check for the maxsub array = target
            if (sum == target)
                maxSub = Math.max(maxSub, right - left + 1);
        }

        // Get minimum subarray reduce X = 0 (the outer values of the maxsubarray)
        // By arr.len - maxsub
        return maxSub == -1 ? -1 : nums.length - maxSub;
    }

}
