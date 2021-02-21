package src.Edu.CyclicSort;

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
    public int findMissingNumberEduIO(int[] nums) {
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
            if (i != nums[i])
                return i;
        }
        return -1;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }

    // Space (1) - Time (N)
    // Using XOR --> a ^ b ^ b = a [Same number will eliminate the number]
    public int missingNumberBitManipulation(int[] nums) {
        int xor = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++)
            xor = xor ^ i ^ nums[i];
        return xor ^ i; // Incase missing the last number that is more than what is inside arr [0,1] ->
                        // 2

    }

    // Space (1) - Time (N)
    public int missingNumberOptimize(int[] nums) {
        int missingNum = nums.length; // Catch the case [0,1] - which the missing number will be 2

        // Cal: len = len + index + nums[index]
        for (int i = 0; i < nums.length; i++) {
            missingNum += i - nums[i]; // if i and nums[i] have the same val, they will cancel out
        }
        return missingNum;
    }
}
