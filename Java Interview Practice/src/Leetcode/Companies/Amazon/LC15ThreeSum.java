package src.Leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC15ThreeSum {

    // Space (N) - Time (N^2)
    // Correct answer using Sort, 2 pointers
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);

        int len = nums.length;
        int mid = 0;
        int right = 0;
        int sum = 0;

        // Loop through all array until reaches the last 2 elements
        for (int left = 0; left < len - 2; left++) {
            // Reset/Init mid and right pointer
            mid = left + 1;
            right = len - 1;

            // Skip duplicate num since last version is already the same
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }

            // Loop and change the mid, right accordingly to the sum
            while (mid < right) {
                sum = nums[left] + nums[mid] + nums[right];

                if (sum == 0) {
                    res.add(new ArrayList<>(List.of(nums[left], nums[mid], nums[right])));
                    right--;
                    mid++;

                    // Move pointer of mid forward to avoid dup (until new val or meet right ptr)
                    while (mid < right && nums[mid] == nums[mid - 1])
                        mid++;

                    // Move pointer of right backward to avoid dup (until new val or meet mid ptr)
                    while (right > mid && nums[right] == nums[right + 1])
                        right--;

                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return res;
    }

    // Space (N) - Time (N ^ 2)
    // Take lot more time compare to the 1 above
    // Use the Set to get only 3 sum of the same set of number once (Avoid
    // duplication in different order)
    public List<List<Integer>> threeSumSet(int[] arr) {
        int sum = 0;
        int start = 0;
        int end = 0;
        Set<List<Integer>> nonDuplicatedSet = new HashSet<>();

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

    // Space (N) - Time (N^2)
    // Take a lot more time compare to the other versions above
    public List<List<Integer>> threeSumHashSetAndMap(int[] nums) {
        int len = nums.length;
        if (len < 3)
            return new ArrayList<>();

        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        int sum = 0;
        int neededValIndex = 0;
        // Go until last 2 elements since 3 sum
        for (int curr = 0; curr < len - 2; curr++) {
            // Skip duplication of prev iteration
            if (curr > 1 && nums[curr] == nums[curr - 1])
                continue;

            // Check each single number before curr
            for (int next = curr + 1; next < len; next++) {
                sum = (nums[curr] + nums[next]) * -1;

                // Check if map contain the index of negative number of 2 sum above
                neededValIndex = map.containsKey(sum) ? map.get(sum) : Integer.MIN_VALUE;

                // If index found and index is more than next ptr (avoid some dup case if map found indices before next ptr),
                // added into the set to keep unique sum set
                if (neededValIndex != Integer.MIN_VALUE && neededValIndex > next) {
                    set.add(new ArrayList<>(List.of(nums[curr], nums[next], nums[neededValIndex])));
                }
            }

        }
        return new ArrayList<>(set);
    }

}
