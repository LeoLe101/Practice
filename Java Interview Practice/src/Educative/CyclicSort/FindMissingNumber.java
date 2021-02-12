package src.Educative.CyclicSort;

public class FindMissingNumber {
    /**
     * We are given an array containing ‘n’ distinct numbers taken from the range 0
     * to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers,
     * find the missing number.
     * 
     * @param nums arr of distinct nums
     * @return the missing number
     */

    // Space (1) - Time (N)
    public int findMissingNumber(int[] nums) {
        if (nums.length < 1)
            return -1;

        int ptr = 0;

        // Sort all arr with the correct indx
        while (ptr < nums.length) {
            // if not correct number in currIndx,
            // swap with the val in correct indx
            // The val of currIndx must be within the arr length
            if (nums[ptr] < nums.length && ptr != nums[ptr]) {
                swap(nums, ptr, nums[ptr]);
            } else {
                ptr++;
            }
        }

        // once sort everything. Loop again and find missing num
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return -1;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }
}
