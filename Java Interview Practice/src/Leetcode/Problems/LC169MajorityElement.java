package src.Leetcode.Problems;

import java.util.HashMap;
import java.util.Map;

public class LC169MajorityElement {


	// Space (N) Time (N)
	public int majorityElement(int[] nums) {
		if(nums.length <= 1) return nums[0];

		int majorThreshold = nums.length / 2;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!m.containsKey(nums[i]))	{
				m.put(nums[i], 1);
			} else {
				int currOccur = m.get(nums[i]) + 1;

				if (currOccur > majorThreshold) 
					return nums[i];
				m.put(nums[i], currOccur);
			}
		}
		return -1;
	}

	// Space (1) Time (N) --- Moore Voting Algo from UTexas
	public int majorityElementOptimized(int[] nums) {
		int major = nums[0];
		int count = 1;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
}
