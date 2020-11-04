package src.Leetcode.Array;

public class MaxConsecutivesOne {
    public int findMaxConsecutiveOnes(int[] nums) {

        int counter = 0;
        int result = 0;

        for (int i : nums) {
            if (i == 0) {
                result = Math.max(counter, result);
                counter = 0;
            } else {
                counter++;
            }
        }
        result = Math.max(counter, result);
        return result;
    }
}