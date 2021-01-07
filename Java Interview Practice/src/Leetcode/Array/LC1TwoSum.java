package src.Leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class LC1TwoSum {

    // Space (N) Time (N)
	public int[] twoSum (int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int needed = target - num;
            if (!map.containsKey(needed)) {
                map.put(num, i);
            }
            else {
                return new int[] { i, map.get(needed) };
            } 
        }
        return new int[] {};
    }





}
