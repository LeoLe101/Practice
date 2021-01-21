package src.Leetcode.Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1679MaxNumberOfKSumPair {

    // Space (N) - Time (N)
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int num : nums) {
            int cal = k - num;
            if (m.getOrDefault(cal, 0) > 0) {
                m.put(cal, m.get(cal) - 1);
                result++;
            } else {
                m.put(num, m.getOrDefault(num, 0) + 1);
            }
        }
        return result;
    }

    // Space (1) - Time (N Log N) Because of sort algo
    public int maxOperationsTwoPtr(int[] nums, int k) {

        Arrays.sort(nums);

        int result = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int total = nums[left] + nums[right];
            if (total > k)
                right--;
            else if (total < k)
                left++;
            else {
                left++;
                right--;
                result++;
            }
        }
        return result;
    }
}
