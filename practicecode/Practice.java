package practicecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

public class Practice {

    /**
     * Remove Duplication in place and return the length of the array that is
     * passed.
     *
     * The Array is passed into the param as reference, so whenever the function is
     * executed, the original array will change too!
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            }

            if (nums[i - 1] != nums[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * Find a sum of 2 indices that is the closest to the target number
     */
    public int[] closestSum(int[] nums, int target) {
        int[] result = new int[2];
        int leftPtr = 0;
        int rightPtr = nums.length - 1;
        int total = 0;
        int[] nums2 = nums.clone();
        Arrays.sort(nums);

        while (leftPtr < rightPtr) {
            total = nums[leftPtr] + nums[rightPtr];
            if (total == target) {
                result[0] = nums[leftPtr];
                result[1] = nums[rightPtr];
                break;
            } else if (total < target) {
                leftPtr++;
            } else if (total >= target) {
                rightPtr--;
            } else {
                result[0] = nums[leftPtr];
                result[1] = nums[rightPtr];
                break;
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == result[0]) {
                result[0] = i;
            }
            if (nums2[i] == result[1] && i != result[0]) {
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * 2 SUM https://leetcode.com/problems/two-sum
     *
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target. You may assume that each input would have
     * exactly one solution, and you may not use the same element twice.
     *
     * This implementation required map/set/hashmap instead of sorting the array
     * first and then find the indices like the twoSum below
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) { // <---- This is the optimized version and the correct version
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // number, index
        }

        for (int i = 0; i < nums.length; i++) {
            int otherIndex = target - nums[i];

            if (map.containsKey(otherIndex) && map.get(otherIndex) != i) {
                result[0] = i;
                result[1] = map.get(otherIndex);
                break;
            }
        }
        return result;
    }

    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = null;

        return result;
    }

    /**
     * SORT MATRIX
     * https://leetcode.com/discuss/interview-question/287420/amazon-recent-interview-question-2019
     *
     * Given a 2D array in which each row is sorted and rotated, you need to come ip
     * with an algorithm which efficiently sort the entire 2D matrix in descenting
     * order.
     *
     * EXAMPLE input: arr[][] = { {41, 45, 20, 21}, {1 ,2, 3, 4}, {30, 42, 43, 29 },
     * {16, 17, 19, 10} }
     *
     * output { { 45, 43, 42, 41}, {30, 29, 21, 20}, {19, 17, 16, 10}, {4, 3, 2, 1}
     * }
     *
     * Interviewer was expecting the solution to run with a complexity < O(n^3)
     * solution.
     */
    public List<List<Integer>> sortMatrix() {
        return null;
    }

    /**
     * Contains Duplicate https://leetcode.com/problems/contains-duplicate/
     *
     * Given an array of integers, find if the array contains any duplicates. Return
     * TRUE if any value appears at least twice in the array, and return FALSE if
     * every element is distinct
     *
     * @param nums: Array of int
     * @return TRUE or FALSE
     */
    public boolean containsDuplicate(int[] nums) { // <---- Array sorted version
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    public boolean containsDuplicateHashMap(int[] nums) { // <---- Data Structure version
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }
        return false;
    }

    /**
     * Product Except Self
     * https://leetcode.com/problems/product-of-array-except-self/
     *
     * Given an array 'nums' of n integers where n > 1, return an array output such
     * that output[i] is equal to the product of all the lements of 'nums' except
     * 'nums[i]'
     *
     * @param nums The array of int
     * @return return the array of product of all element except for the current
     *         element
     */
    public int[] productExceptSelf(int[] nums) { // <---- This is the cheated verison with division

        // NOTE WILL BE REVIEWED AGAIN SOON!

        return null;
    }

    public int[] productExceptSelfNested(int[] nums) { // <---- This is the un-optimized verison with nested Loop
        int length = nums.length;
        int[] result = new int[length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                if (k != i) {
                    product *= nums[k];
                } else {
                    continue;
                }
            }
            result[i] = product;
            product = 1;
        }
        return result;
    }

    /**
     * Climbing Stairs https://leetcode.com/problems/climbing-stairs/
     *
     * Climbing a stair case. It takes n steps to reach to the top. Each time can
     * either climb 1 or 2 steps. In how many distinct ways can you climb to the
     * top?
     *
     * @param n Positive integer of the amount of steps to reach the top
     * @return The number of possible ways to climb up to the top
     */
    public int climbStaits(int n) {

        int result = 0;
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return result;
    }

    /**
     * Reverse Linked List https://leetcode.com/problems/reverse-linked-list/
     *
     * Reverse a singly linked list Follow up: Implement both iterative and
     * recursive
     *
     * Definition for singly-linked list. public class ListNode { int val; ListNode
     * next; ListNode(int x) { val = x; } }
     */

    public ListNode reverseList(ListNode head) {

        return null;
    }

    /**
     * Merge Sorted Array https://leetcode.com/problems/merge-sorted-array/
     *
     * Given 2 sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one
     * sorted array.
     *
     * Notes: The number of elements initialized in nums1 and nums2 are m and n
     * respectively. Assume that nums1 has enough space (size >= (m + n)) to hold
     * additional elements from nums2.
     */
    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

    }

    /**
     * Coin Change MEDIUM <But Hard as hell... DP question>
     * https://leetcode.com/problems/coin-change/
     *
     * Given coins of different denominations and a total amount of money amount.
     * Write a function to compute the fewest number to coins that you need to make
     * up that amount. If that amount of money cannot be made up by any combination
     * of the coins, return -1
     *
     * @param coins  array of coins value
     * @param amount the amount to meet with the amount of coin
     * @return the number of coins to create the amount
     */
    public int counChange(int[] coins, int amount) {

        return -1;
    }

    /**
     * Middle of the Linked List
     * https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * Given a non-empty, singly linked list with a head node return a middle node
     * of the linked list. If there are 2 middle nodes, return the second middle
     * node
     *
     * @param head starting Node return The middle node of the whole linked list
     */
    public ListNode middleNode(ListNode head) { // <<<<<<< This is accepted and corrected
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    public ListNode middleNodePtr(ListNode head) { // <<<<<<< This is the second way to solve this
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
