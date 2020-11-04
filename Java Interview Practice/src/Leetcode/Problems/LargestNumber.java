package src.Leetcode.Problems;

import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        int counter = 0;
        int maxNum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        // find the amount of number
        for (int i = 0; i < nums.length; i++) {
            maxNum += Integer.toString(nums[i]).length();
        }
        for (int i = 0; i < nums.length; i++) {
            int amountZero = maxNum - Integer.toString(nums[i]).length();
            nums[i] = nums[i] * (10 * amountZero);
            queue.add(nums[i]);
        }
        maxNum *= 10;
        while (counter > 0) {
            int curr = queue.poll();
            maxNum = curr;
        }
        return null;
    }
}
