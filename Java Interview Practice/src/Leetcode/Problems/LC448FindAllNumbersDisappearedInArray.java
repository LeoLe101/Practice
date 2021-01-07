package src.Leetcode.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC448FindAllNumbersDisappearedInArray {

    // Space (N) Time (N Log N)
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        if (len < 1) return null;
        int prev = 0;
        Arrays.sort(nums); // N Log N
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < len; i++) {
            prev = nums[i - 1] + 1; 
            if (nums[i] != prev && nums[i] > prev)
                result.add(nums[i]);
        }
        return result;
    }
    
}
