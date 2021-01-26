package src.Educative.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

    // #region Maxiumum Sum Subarray of Size K: Space (1) Time (N)
    /**
     * Given an array of positive numbers and a positive number ‘k,’ find the
     * maximum sum of any contiguous subarray of size ‘k’.
     * 
     * @param k   Range to find the Max Sum Subarray
     * @param arr Array given
     * @return The max Sum Subarray
     */
    public int findMaxSumSubArray(int k, int[] arr) {
        int result = -1;
        int fastPtr = k - 1;
        int sum = 0;
        int counter = 0;

        // Move the SlowPtr until meet the FastPtr, then increment the FastPtr by 1 and
        // and check sum, then restart the SlowPtr to the counter
        for (int slowPtr = 0; slowPtr < arr.length; slowPtr++) {
            sum += arr[slowPtr];

            if (slowPtr == fastPtr) {
                result = Math.max(sum, result);
                sum -= arr[counter];
                counter++;
                fastPtr++;
            }
        }
        return result;
    }

    public int findMaxSumSubArrayEdu(int k, int[] arr) {
        int windowSum = 0, maxSum = 0, windowStart = 0;

        // Move the windowEnd until it is more than K range,
        // then increase windowStart by 1 and check sum
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window
            // size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
    // #endregion

    // #region Smallest Subarray with a given sum: Space (1) Time (N * K) where N
    // size the array iteration through each element and K is the Window Size
    /**
     * Given an array of positive numbers and a positive number ‘S,’ find the length
     * of the smallest contiguous subarray whose sum is greater than or equal to
     * ‘S’. Return 0 if no such subarray exists.
     * 
     * @param s   Target for the sum to compare with
     * @param arr Array given
     * @return Smallest subarray size whose sum is > || = to given S number
     */
    // REVIEW Not all edge cases are covered with this solution
    // Space (1) Time (N*K)
    public int findMinSubArrayError(int s, int[] arr) {
        int sum = 0, slowPtr = 0, len = arr.length, windowSize = 1;
        while (windowSize < len) {
            // Find the largest Sum is greater or equal to target s
            for (int fastPtr = 0; fastPtr < len; fastPtr++) {
                sum += arr[fastPtr];
                if (fastPtr + 1 >= windowSize) {
                    if (sum >= s)
                        return windowSize;
                    sum -= arr[slowPtr];
                    slowPtr++;
                }
            }
            // Reset slowPtr and increase windowSize
            slowPtr = 0;
            windowSize++;
        }
        return 0;
    }

    // Space (N) Time (N^2)
    public int BF_findMinSubArray(int s, int[] arr) {
        int sum = 0, result = Integer.MAX_VALUE;
        for (int slowPtr = 0; slowPtr < arr.length; slowPtr++) {

            for (int fastPtr = slowPtr; fastPtr < arr.length; fastPtr++) {
                sum += arr[fastPtr];
                if (sum >= s) {
                    result = Math.min(result, sum);
                    break;
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : 0; // If Max, return 0 instead
    }

    // Space (1) Time (N)
    public int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        // Loop through the window to find number > 'S'
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            // if the sum is more than 'S',
            // Shrink windowSize until the 'windowSum' < 'S'
            while (windowSum >= S) { // Must be while to shrink all the possibilities down to get the most minimal
                                     // values of the whole sum
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // remove the first element
                windowStart++; // move window up
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength; // If Max, return 0 instead
    }

    // #endregion

    // #region Find the average of all contiguous subarrays of size ‘5’ in the given
    // array.
    // Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    // Output: [2.2, 2.8, 2.4, 3.6, 2.8]
    public double[] BF_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1]; // Since the window is always K size
        double sum = 0.0;
        for (int i = 0; i <= arr.length - k; i++) {
            for (int j = 0; j < i + k; j++) {
                sum += arr[j];
            }
            result[i] = sum / k;
        }
        return result;
    }

    // Optimization: Save the calculated common areas within the array by minus the
    // first and add the last elmnt
    public double[] OPT_AverageContigousSubArr(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double sum = 0.0;
        int windowStart = 0;

        // First calculation
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // Starting optimization calculation
        for (int j = 0; j < result.length; j++) {
            if (j > 0) {
                sum = sum - arr[windowStart] + arr[j + k - 1];
            }
            result[j] = sum / k;
            windowStart = j;
        }
        return result;
    }

    // #endregion

    // #region Find longest substring within K distinct characters

    // Space (K) Time (N) - K is the amount of character stored in map
    public int findLength(String str, int k) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            // Keep putting curr char into the map
            char currChar = str.charAt(end);
            m.put(currChar, m.getOrDefault(currChar, 0) + 1);

            // Shrink down the map if char in map >= K
            while (m.size() >= k) {
                // Reduce from start till map only contain the right amount of char
                char startChar = str.charAt(start);
                m.put(startChar, m.get(startChar) - 1);
                if (m.get(startChar) == 0) {
                    m.remove(startChar);
                }
                start++;
            }

            // Set curr Max length
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    // #endregion

    // #region Find the maximum number of fruits in each basket (Fruits into
    // Baskets)

    // Space (N) - Time (N)
    public int findLength(char[] arr) {
        int len = arr.length;
        int max = 0;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();

        for (int end = 0; end < len; end++) {
            char curr = arr[end];
            m.put(curr, m.getOrDefault(curr, 0) + 1);

            while (m.size() > 2) {
                char leftChar = arr[start];
                m.put(leftChar, m.get(leftChar) - 1);

                if (m.get(leftChar) == 0)
                    m.remove(leftChar);

                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    // #endregion

    // #region Find the length of the longest substring which has no repeating
    // characters

    // Space (N) - Time (N)
    public int findLengthOfSubStrWithNoRepeatChar(String str) {
        int len = str.length();
        int maxSub = 0;
        int start = 0;
        Map<Character, Integer> m = new HashMap<>();

        for (int end = 0; end < len; end++) {
            char curr = str.charAt(end);
            m.put(curr, m.getOrDefault(curr, 0) + 1);

            while (m.get(curr) > 1) {
                char leftChar = str.charAt(start);
                m.put(leftChar, m.get(leftChar) - 1);
                if (m.get(leftChar) < 1) {
                    m.remove(leftChar);
                }
                start++;
            }
            maxSub = Math.max(maxSub, end - start + 1);
        }
        return maxSub;
    }

    // Space (N) - Time (N)
    // Faster run time, but takes more memory
    public int findLengthOfSubStrWithNoRepeatChar2(String str) {
        int start = 0, maxSub = 0, len = str.length();
        Set<Character> s = new HashSet<>();

        for (int end = 0; end < len; end++) {
            char curr = str.charAt(end);

            // Move the start ptr to the next index of the char already in the str
            // ex: abcdec -> move start ptr to 'D' because C is already in Set
            if (s.contains(curr)) {
                while (start <= end) {
                    char leftChar = str.charAt(start);
                    if (leftChar == curr) {
                        start++;
                        break;
                    }

                    // Remove char along the way
                    s.remove(leftChar);
                    start++;
                }

            } else {
                s.add(curr);
                maxSub = Math.max(maxSub, s.size());
            }
        }
        return maxSub;
    }

    // #endregion

    // #region Longest Repeating Character Replacement

    // Space (N) Time (N)
    public int characterReplacement(String s, int k) {
        int maxSub = 0, maxLen = 0, len = s.length(), left = 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();

        for (int end = 0; end < len; end++) {
            char curr = s.charAt(end);
            m.put(curr, m.getOrDefault(curr, 0) + 1);
            maxSub = Math.max(maxSub, m.get(curr));

            if (end - left + 1 - maxSub > k) {
                char leftChar = s.charAt(left);
                m.put(leftChar, m.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, end - left + 1);
        }
        return maxLen;
    }

    // #endregion

}