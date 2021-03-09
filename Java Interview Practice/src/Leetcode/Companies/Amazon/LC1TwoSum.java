package src.Leetcode.Companies.Amazon;

import java.util.HashMap;
import java.util.Map;

public class LC1TwoSum {

    // Space (N) - Time (N)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> m = new HashMap<>();
        int needed = 0;
        for (int i = 0; i < nums.length; i++) {
            needed = target - nums[i];
            if (m.containsKey(needed) && i != m.get(needed)) {
                result[0] = i;
                result[1] = m.get(needed);
                return result;
            }
            else {
                m.put(nums[i], i);
            }
        }

        return result;
    }
}
