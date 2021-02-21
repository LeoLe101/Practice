package src.Edu.CyclicSort;

import java.util.LinkedList;
import java.util.List;

public class FindAllMissingNumber {
    /**
     * We are given an unsorted array containing numbers taken from the range 1 to
     * ‘n’. The array can have duplicates, which means some numbers will be missing.
     * Find all those missing numbers.
     * 
     * @param nums the number arr
     * @return list of missing numbers
     */
    public List<Integer> findNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums.length < 1)
            return result;
        int i = 0;
        while (i < nums.length) {
            // If the current is not the same as the index's val expected, swap
            // 2 != 3 (SWAP) -- 2 == 2 (SKIP/Move forward)
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, nums[i] - 1, i);
            else
                i++;
        }

        // Check again, if the index's val at that index location is not index + 1
        // that is the missing number
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
