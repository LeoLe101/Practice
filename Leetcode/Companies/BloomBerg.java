import java.util.*;

public class BloomBerg {

    /**
     * Question #387 | Acceptance: 47.6% | Level: Easy
     * https://leetcode.com/problems/first-unique-character-in-a-string/
     * 
     * Question #205 | Acceptance: 35.5% | Level: Easy
     * https://leetcode.com/problems/isomorphic-strings/
     * 
     * Question #70 | Acceptance: 42.0% | Level: Easy
     * https://leetcode.com/problems/climbing-stairs/
     * 
     * Question #20 | Acceptance: 34.6% | Level: Easy
     * https://leetcode.com/problems/valid-parentheses/
     * 
     * Question #1 | Acceptance: 38.9% | Level: Easy
     * https://leetcode.com/problems/two-sum/
     * 
     * Question #138 | Acceptance: 25.6% | Level: Medium
     * https://leetcode.com/problems/copy-list-with-random-pointer/
     * 
     * Question #98 | Acceptance: 24.4% | Level: Medium
     * https://leetcode.com/problems/validate-binary-search-tree/
     * 
     * Question #200 | Acceptance: 38.0% | Level: Medium
     * https://leetcode.com/problems/number-of-islands/
     * 
     * Question #242 | Acceptance: 48.9% | Level: Easy
     * https://leetcode.com/problems/valid-anagram/
     * 
     * Question #463 | Acceptance: 58.6% | Level: Easy
     * https://leetcode.com/problems/island-perimeter/
     * 
     * Question #347 | Acceptance: 50.9% | Level: Medium
     * https://leetcode.com/problems/top-k-frequent-elements/
     * 
     * Question #102 | Acceptance: 44.7% | Level: Medium
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * 
     * Question #121 | Acceptance: 44.4% | Level: Easy
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * 
     * Question #451 | Acceptance: 52.9% | Level: Medium
     * https://leetcode.com/problems/sort-characters-by-frequency/
     * 
     * Question #283 | Acceptance: 52.4% | Level: Easy
     * https://leetcode.com/problems/move-zeroes/
     * 
     * Question #698 | Acceptance: 38.7% | Level: Medium
     * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
     * 
     * Question #33 | Acceptance: 32.1% | Level: Medium
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * 
     * Question #3 | Acceptance: 25.0% | Level: Medium
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * 
     * Question #380 | Acceptance: 40.5% | Level: Medium
     * https://leetcode.com/problems/insert-delete-getrandom-o1/
     * 
     * Question #582 | Acceptance: 52.6% | Level: Medium
     * https://leetcode.com/accounts/login/?next=/problems/kill-process/
     * 
     * Question #26 | Acceptance: 37.8% | Level: Easy
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * 
     * Question #60 | Acceptance: 30.7% | Level: Medium
     * https://leetcode.com/problems/permutation-sequence/
     * 
     * Question #153 | Acceptance: 41.6% | Level: Medium
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * 
     * Question #10 | Acceptance: 24.4% | Level: Hard
     * https://leetcode.com/problems/regular-expression-matching/
     * 
     * Question #42 | Acceptance: 39.2% | Level: Hard
     * https://leetcode.com/problems/trapping-rain-water/
     */
}

/**
 * 387. First Unique Character in a String Given a string, find the first
 * non-repeating character in it and return its index. If it doesn't exist,
 * return -1.
 * 
 * s = "leetcode" return 0. s = "loveleetcode" return 2.
 * 
 * @Note: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Q387 {

    public int firstUniqChar(String str) {

    }

    public int minDominoRotation(int[] A, int[] B) {

        if (A.length < 1 || B.length < 1)
            return -1;

        // Find the max occurence
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();

        for (int i : A) {
            if (mapA.containsKey(i)) {
                mapA.put(i, mapA.get(i) + 1);
            } else {
                mapA.put(i, 1);
            }
        }

        for (int i : B) {
            if (mapB.containsKey(i)) {
                mapB.put(i, mapB.get(i) + 1);
            } else {
                mapB.put(i, 1);
            }
        }

        int maxA = Integer.MIN_VALUE;
        int countA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        int countB = Integer.MIN_VALUE;
        int result = -1;
        boolean flag = false;

        for (Map.Entry<Integer, Integer> e : mapA.entrySet()) {
            int currVal = e.getValue();
            if (currVal > countA) {
                countA = currVal;
                maxA = e.getKey();
            }
        }
        for (Map.Entry<Integer, Integer> e : mapB.entrySet()) {
            int currVal = e.getValue();
            if (currVal > countB) {
                countB = currVal;
                maxB = e.getKey();
            }
        }

        // A occur > B, checks B if at that index of A is not max occurence, but B is
        // max occurnce val
        if (countA > countB) {
            for (int ind = 0; ind < A.length; ind++) {
                if (A[ind] != maxA && B[ind] == maxA) {
                    result++;
                }
            }
            flag = true;
        } else { // Vice versa
            for (int ind = 0; ind < B.length; ind++) {
                if (B[ind] != maxB && A[ind] == maxB) {
                    result++;
                }
            }
            flag = true;
        }
        return flag ? result : result++;
    }

    public int minDominoRotations(int[] A, int[] B) {
        Map<Integer, Integer> ma = new HashMap<>();
        Map<Integer, Integer> mb = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pqa = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // Syntax
                                                                                                                     // for
                                                                                                                     // lambda
                                                                                                                     // from
                                                                                                                     // Max
                                                                                                                     // to
                                                                                                                     // Min
                                                                                                                     // in
                                                                                                                     // comparision
        PriorityQueue<Map.Entry<Integer, Integer>> pqb = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int a : A) {
            ma.put(a, ma.getOrDefault(a, 0) + 1); // Clean code for putting in code and change it. IF the map does not
                                                  // have this key, use 0 + 1 as value.
        }
        for (int b : B) {
            mb.put(b, mb.getOrDefault(b, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : ma.entrySet()) { // Entry Set doesn't return order, it will go random
            pqa.add(e); // Once put in Priority Queue, it will order the key buy value as defined above
                        // when init
        }
        for (Map.Entry<Integer, Integer> e : mb.entrySet()) {
            pqb.add(e);
        }
        int resa = Integer.MAX_VALUE;
        while (!pqa.isEmpty()) {
            Map.Entry<Integer, Integer> e = pqa.poll();
            int cur = e.getKey();
            int temp = 0;
            boolean possible = true;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != cur && B[i] == cur) {
                    temp += 1;
                } else if (A[i] != cur && B[i] != cur) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                resa = Math.min(resa, temp);
            }
        }
        int resb = Integer.MAX_VALUE;
        while (!pqb.isEmpty()) {
            Map.Entry<Integer, Integer> e = pqb.poll();
            int cur = e.getKey();
            int temp = 0;
            boolean possible = true;
            for (int i = 0; i < B.length; i++) {
                if (B[i] != cur && A[i] == cur) {
                    temp += 1;
                } else if (A[i] != cur && B[i] != cur) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                resb = Math.min(resb, temp);
            }
        }
        int res = Math.min(resa, resb);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public String largestNumber(int[] nums) {

        String arr[] = new String[nums.length];
        int counter = 0;
        int maxNum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        // find the amount of number
        for (int i = 0; i < nums.length; i++) {
            maxNum += Integer.toString(nums[i]).size();
        }

        for (int i = 0; i < nums.length; i++) {
            int amountZero = maxNum - Integer.toString(nums[i]).size();
            nums[i] = nums[i] * (10 * amountZero);
            queue.add(nums[i]);
        }
        
        maxNum *= 10;

        while (counter > 0) {

            int curr = queue.poll();

            maxNum = curr;
        }
    }
}
