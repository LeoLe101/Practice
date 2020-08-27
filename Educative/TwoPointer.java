import java.lang.reflect.Constructor;

import java.util.*;
import java.util.function.IntPredicate;

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

    /**
     * Remove duplication in line from a sorted number array given !!! This solution
     * only count the length of the array when deleted happened. It doesn't delete
     * anything !!! Which is cheated!
     * 
     * @param arr Sorted Number Array
     * @return Length of the array after deletion
     */
    public int removeBF(int[] arr) {

        if (arr.length < 1)
            return 0;

        int start = 0;
        int counter = 1;

        for (int end = 1; end < arr.length; end++) {
            if (arr[start] != arr[end]) {
                start = end;
                counter++;
            }
        }

        return counter;
    }

    /**
     * The trick is to move to the second duplication value instead of the first
     * duplication value. After that do the value re-assign there.
     * 
     * Time: O(N) Space: O(1)
     */
    public int removeCorrectVersion(int[] arr) {

        if (arr.length < 1)
            return 0;

        int start = 1;
        for (int end = 1; end < arr.length; end++) {
            // Only target where the first duplication is not the same as current elment
            // This logic stop the first pointer at the second duplication in the array
            // (Since we only need 1 of the number.)
            if (arr[start - 1] != arr[end]) {
                arr[start] = arr[end];
                start++;
            }
        }
        return start;
    }

    /**
     * Given an unsorted array of numbers and a target ‘key’ remove all instances of
     * ‘key’ in-place and return the new length of the array.
     * 
     * Time: O(N) Space: O(1)
     * 
     * @param arr Unsorted Number Array
     * @param key Key to be removed
     * @return Length of the new array
     */
    public int remove(int[] arr, int key) {
        int start = 0;
        for (int end = 0; end < arr.length; end++) {

            // Only target the number that is not Key and push them toward the start of the
            // array
            if (arr[end] != key) {
                arr[start] = arr[end];
                start++;
            }
        }
        return start;
    }

    /**
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     * 
     * @param arr Sorted Array
     * @return in-line Sorted Squares of all the numbers in given array
     */
    public int[] makeSquaresInLine(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int startSquare = 0;
        int endSquare = 0;

        while (start < end) {
            startSquare = arr[start] * arr[start];
            endSquare = arr[end] * arr[end];

            if (startSquare > endSquare) {
                arr[start] = arr[end];
                arr[end] = startSquare;
            } else {
                arr[end] = endSquare;
            }
            end--;
        }
        return arr;
    }

    /**
     * Given a sorted array, create a new array containing squares of all the number
     * of the input array in the sorted order.
     * 
     * Time: O(N)
     * Space: O(N)
     * 
     * @param arr Sorted Array
     * @return    A NEW Sorted Squares of all the numbers in given array
     */
    public int[] makeSquaresNewArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int resultEnd = end;
        int startSquare = 0;
        int endSquare = 0;
        int[] result = new int[end + 1];

        while (start <= end) {
            startSquare = arr[start] * arr[start];
            endSquare = arr[end] * arr[end];

            if (startSquare > endSquare) {
                result[resultEnd--] = startSquare;
                start++;
            } else {
                result[resultEnd--] = endSquare;
                end--;
            }
        }
        return result;
    }
}