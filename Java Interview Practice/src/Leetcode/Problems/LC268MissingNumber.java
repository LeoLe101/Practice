package src.Leetcode.Problems;

import java.util.HashSet;
import java.util.Set;

public class LC268MissingNumber {

    // Space (N) - Time (N)
    public int missingNumber(int[] nums) {
        int[] result = new int[nums.length + 1];
        // increase count of result by 1 for each element as index in result
        for (int i : nums) {
            result[i]++;
        }

        // Check all element in result, if < 1, that is the missing number
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 1)
                return i;
        }
        return nums[nums.length - 1] + 1;
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

    // Space (N) - Time (N)
    public int missingNumberTest(int[] nums) {
      Set<Integer> s = new HashSet<>();
      for (int i : nums) {
        s.add(i);
      }
      for (int i = 0; i < nums.length; i++) {
        if (!s.contains(i)) return i;
      }
      return nums.length;
    }

}