package src.Leetcode.Problems;

import java.util.Arrays;

public class LC268MissingNumber {

    public int missingNumber(int[] nums) {

        if (nums.length - 1) {

        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] - nums[i - 1];

            if (cur != 1) {
                return nums[i - 1] + 1;
            }
        }

        return 0;
    }

}