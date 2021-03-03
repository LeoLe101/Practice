package src.Leetcode.Problems;

public class LC645SetMismatch {

    // Space (1) - Time (N Log N) - N Log N becuase of the sort
    public int[] findErrorNumsMath(int[] nums) {
        int[] res = new int[2]; 

        // set nums[number-1] to its negative value (<0)
        for (int i = 0; i < nums.length; i++) {

            // Get the index of alternated value
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0)
                nums[idx] = -nums[idx];
            else
                res[0] = idx + 1; // have already been found
        }
        // At this point, only nums[missingNumber-1] > 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = -nums[i]; // restore the original values
            else
                res[1] = i + 1;// since index starts from 0, and the set starts from 1
        }
        return res;
    }

    // Space (1) - Time (N)
    public int[] findErrorNumsCylicSort(int[] nums) {
        int temp = 0;
        int curr = 0;

        // Cyclic Sort
        while (curr < nums.length) {
            // If the curr number is not the same with the number at the correct index
            // and the number is not the same as it's corresponding index, swap
            if (nums[curr] != curr + 1 && nums[curr] != nums[nums[curr] - 1]) {
                temp = nums[nums[curr] - 1];
                nums[nums[curr] - 1] = nums[curr];
                nums[curr] = temp;
            } else {
                curr++;
            }
        }

        // Re-loop and check if the curr index has correct corresponding value
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] { nums[i], i + 1 };
            }
        }

        return new int[] {};
    }
}
