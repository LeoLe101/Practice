package src.Leetcode.Problems;

public class LC704BinarySearch {

    // Iteration version Space O(1), Time O(Log N)
    public int searchIterative(int[] nums, int target) {
        int result = -1;
        if (nums.length < 1)
            return result;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                result = mid;
                break;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Recursion Version Space (N) with N is the number of recursive call Time (Log N)
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (target == nums[mid])
            return mid;
        if (target < nums[mid])
            return searchHelper(nums, target, left, mid - 1);

        return searchHelper(nums, target, mid + 1, right);
    }

}
