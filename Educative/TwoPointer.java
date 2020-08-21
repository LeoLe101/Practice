import java.lang.reflect.Constructor;

import java.util.*;

public class TwoPointer {

    public TwoPointer() {
    }

    /**
     * Input: [2, 5, 9, 11], target=11 Output: [0, 2] Explanation: The numbers at
     * index 0 and 2 add up to 11: 2+9=11
     * 
     * @param arr       Array given
     * @param targetSum Target Sum
     * @return Pair of Index where the sum is the target sum
     */
    public int[] search(int[] arr, int targetSum) {

        int[] result = new int[2];
        int ptr1 = 0;
        int ptr2 = arr.length - 1;
        int sum = 0;

        while (ptr1 < ptr2) {
            sum = arr[ptr1] + arr[ptr2];
            if (sum == targetSum) {
                result[0] = ptr1;
                result[1] = ptr2;
                break;
            } else if (sum > targetSum) {
                ptr2--;
            } else {
                ptr1++;
            }
        }

        return result;
    }

    public int[] searchAlternative(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[] { nums.get(targetSum - arr[i]), i };
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[] { -1, -1 }; // pair not found
    }

}