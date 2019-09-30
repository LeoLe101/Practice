package practicecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Mock {

    /**
     * ----------------------------------------------------------------------------------------
     * MOCK INTERVIEW LEETCODE Given a positive integer, return its corresponding
     * column title as appear in an Excel sheet. 1 > A 2 > B 3 > C ... 26 > Z 27 >
     * AA
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {

        return null;
    }

    /**
     * Given a matrix of m X n elements (m rows, n columns), return all elements of
     * the matrix in spiral order. [ [1,2,3], [4,5,6], [7,8,9] ] >>>>>
     * [1,2,3,6,9,8,7,4,5]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < rowLength; i++) {
            for (int k = 0; k < rowLength; k++) {

            }
        }

        return null;
    }

    /**
     * 2 sorted arrays nums1 and nums2 of size m and n respectively. Find the median
     * of the two sorted arrays.
     *
     * Time Complexity : O(log(m+n))
     *
     * @param nums1 array 1
     * @param nums2 array 2
     * @return median
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // <<<<<<<< This is not correct! Require REVIEW
        int total1 = 0;
        int total2 = 0;
        int amountNumb = nums1.length + nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            total1 += nums1[i];
        }

        for (int k = 0; k < nums2.length; k++) {
            total2 += nums2[k];
        }

        double result = (total1 + total2) / amountNumb;
        return result;
    }

    // Find the largest number in the list
    public long largestNumber(long[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        long result = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        return result;
    }

    // Write a functino to see if a string is a permutation of a palindrom string.
    public boolean permutationPalindrome(String s) { // <<<<< Correct! But Require REVIEW
        int ptr2 = 1;
        int oddOcc = 0;
        String sorted = sortString(s);
        for (int i = 0; i < sorted.length();) {
            if (ptr2 > sorted.length() - 1) {
                oddOcc++;
                break;
            }
            if (sorted.charAt(i) != sorted.charAt(ptr2)) {
                oddOcc++;
                i = ptr2;
                ptr2++;
            } else {
                i += 2;
                ptr2 += 2;
            }
        }
        if (oddOcc > 1) {
            return false;
        }
        return true;
    }

    // This function is required for the permutation of Palindrome function above
    public String sortString(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    // Given a string, find the length of the longest substring that
    // contains no repeated characters
    public long findLongestSubString(String s) { // <<<<<< This is corrected and accepted
        int strLength = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < strLength && ptr2 < strLength) {
            // try to extend the range [ptr1, ptr2]
            if (!set.contains(s.charAt(ptr2))) {
                set.add(s.charAt(ptr2++));
                ans = Math.max(ans, ptr2 - ptr1);
            } else {
                set.remove(s.charAt(ptr1++));
            }
        }
        return ans;
    }

    /**
     * Given a m x n matrix, if an element is 0, set the entire row and column to 0.
     * Do in-place
     *
     * ex1: [ [1,1,1], [1,0,1], [1,1,1] ] output: [ [1,0,1], [0,0,0], [1,0,1] ]
     *
     * ex1: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] output: [ [0,0,0,0], [0,4,5,0],
     * [0,3,1,0] ]
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) { // <<<<<< This is corrected and accepted
        int rowLength = matrix[0].length;
        int colLength = matrix.length;
        ArrayList<Integer> colRec = new ArrayList<Integer>();
        ArrayList<Integer> rowRec = new ArrayList<Integer>();
        for (int i = 0; i < colLength; i++) {
            for (int k = 0; k < rowLength; k++) {
                if (matrix[i][k] == 0) {
                    colRec.add(k);
                    rowRec.add(i);
                } else {
                    continue;
                }
            }
        }
        for (int m = 0; m < colRec.size(); m++) {
            for (int i = 0; i < colLength; i++) {
                matrix[i][colRec.get(m)] = 0;
            }
        }

        for (int m = 0; m < rowRec.size(); m++) {
            for (int k = 0; k < rowLength; k++) {
                matrix[rowRec.get(m)][k] = 0;
            }
        }
    }

    /**
     * Implement atoi which converts a string to an integer
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        str = str.trim();
        int i = 0;
        double result = 0;
        char signed = '+';
        if (str.isEmpty() || str == null) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            signed = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (signed == '-') {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}