package src.Edu.CyclicSort;

public class CyclicSort {

    /**
     * Write a funct to sort obj in-place on their creation sequence number in Time
     * O(N) with Space O(1)
     * 
     * @param nums Array of number sequence
     */

    // Space (1) - Time (N)
    public void sortPersonal(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (min > num)
                min = num;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = min;
            min += 1;
        }
    }

    // Space (1) - Time (N)
    public void sort(int[] nums) {
        int ptr = 0;
        int currNum = 0;
        int tempNum = 0;

        while (ptr < nums.length) {
            currNum = nums[ptr];

            // Curr index doesn't has correct val
            if ((ptr + 1) != currNum) {
                tempNum = nums[currNum - 1];
                nums[currNum - 1] = currNum;
                nums[ptr] = tempNum;
            } else {
                ptr++;
            }
        }

    }

    // Space (1) - Time (N)
    public static void sortEducativeIO(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
