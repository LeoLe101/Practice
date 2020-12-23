package src.Leetcode.Array;

public class LC217ContainsDuplicate {

	// Space (N) Time (N)
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			if (!s.contains(i)) {
				s.add(i);
			} else {
				return true;
			}
		}
		return false;
	}

	// Space (1) Time (N)
	public boolean bruteForceVersion(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) 
					return true;
			}
		}
		return false;
	}
