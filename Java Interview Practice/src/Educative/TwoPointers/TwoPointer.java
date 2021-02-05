package src.Educative.TwoPointers;

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
     * Time: O(N) Space: O(N)
     * 
     * @param arr Sorted Array
     * @return A NEW Sorted Squares of all the numbers in given array
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

    /**
     * Given an array of unsorted numbers, find all unique triplets in it that add
     * up to zero.
     * 
     * Input: [-3, 0, 1, 2, -1, 1, -2] Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1],
     * [-1, 0, 1] Explanation: There are four unique triplets whose sum is equal to
     * zero.
     * 
     * Time and Space: O(N^2)
     */
    public List<List<Integer>> threeSum(int[] arr) {
        int sum = 0;
        int start = 0;
        int end = 0;
        Set<List<Integer>> nonDuplicatedSet = new HashSet<List<Integer>>();

        // sort the array
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            start = i + 1;
            end = arr.length - 1;
            while (start < end) {
                sum = arr[i] + arr[start] + arr[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    nonDuplicatedSet.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                }
            }
        }
        return new ArrayList<>(nonDuplicatedSet);
    }

    /**
     * Optimized version of 3 SUM triplets to 0
     * 
     * @param arr
     * @return
     */
    public List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue;
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--; // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }

    public int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) // we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have
                // more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum
            }
        }
        return targetSum - smallestDifference;
    }
}