package src.Edu.CyclicSort;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicateNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;

        // sort all the val to their corresponding index
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        // check back and see if any number is not
        // correct corresponding val to its index
        List<Integer> duplicateNumbers = new LinkedList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }
        return duplicateNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
