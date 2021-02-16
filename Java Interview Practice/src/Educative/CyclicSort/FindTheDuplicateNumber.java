package src.Educative.CyclicSort;

import java.util.Arrays;

public class FindTheDuplicateNumber {

    /**
     * Follow up questions: How can we prove that at least one duplicate number must
     * exist in nums? - Put into a new array/map with the number value as key.
     * Everytime the dup, increment the value at that index
     * 
     * Can you solve the problem without modifying the array nums? - Do total
     * calculation
     * 
     * Can you solve the problem using only constant, O(1) extra space? Can you
     * solve the problem with runtime complexity less than O(n2)?
     * 
     * @param nums
     * @return
     */

    // Space (1) - Time (N Log N) - This will modify the array
    public int findNumber(int[] nums) {
        if (nums.length < 1)
            return -1;

        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                return nums[i];
            }
            j = i;
        }
        return -1;
    }

    // Space (1) - Time (N)
    // Because nums[] are from 1 - N and only 1 number is duplicated multiple time
    // We can negate all the number at the index = val - 1
    // If the same number dup, the index will be the same as the number already
    // negated then return that number
    public int findNumberByNegation(int[] a) {
        int currNumber = 0;
        for (int i = 0; i < a.length; i++) {
            currNumber = a[i];

            // If the currNumber - 1 is already negate,
            // which mean the number is already duplicated and negated this val already
            if (a[Math.abs(currNumber) - 1] < 0)
                return Math.abs(currNumber);

            // Negate the currNumber - 1, use currNumber as index since 1 - N range
            else
                a[Math.abs(currNumber) - 1] = -a[Math.abs(currNumber) - 1];
        }
        return -1;
    }

    // Space (1) - Time (N)
    // Since the range is 1 - N and multi duplicate of 1 number
    // this will create a cycled connection (Similar to LL cycled II problem)
    public int findNumberByFastnSlowPointers(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            // Find the meet up location
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            // Reset 1 ptr
            fast = 0;

            // Find the start of the cycle (which is the duplicate val)
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

}
