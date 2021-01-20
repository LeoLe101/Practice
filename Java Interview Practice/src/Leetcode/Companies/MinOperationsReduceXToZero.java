package src.Leetcode.Companies;

public class MinOperationsReduceXToZero {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int result = 0;
        int left = 0;
        int right = len - 1;
        if (len < 1)
            return -1;

        while (left < right) {

            int resLeft = x - nums[left];
            int resRight = x - nums[right];

            if (x == 0)
                return result;

            if (nums[left] > x && nums[right] > x) {
                return -1;
            }

            if (nums[left] < x && nums[right] > x) {
                left++;
                result++;
                x = resLeft;
                continue;
            }

            if (nums[right] < x && nums[left] > x) {
                right++;
                result++;
                x = resRight;
                continue;
            }

            if (resLeft > resRight) {
                left++;
            } else {
                right++;
            }
            x = Math.min(resLeft, resRight);
            result++;
        }

        return -1;
    }
}