package src.Leetcode.Problems;

import java.util.Arrays;

public class LC88MergeSortedArray {

    /**
     * Space (1)
     * Time (N)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Use pointers at the end of each arr
        // Use m and n since these are the amount of actual number which not including 0
        int tail1 = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;

        // loop until either tail reach the start of the arr
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ? 
                nums1[tail1--] : 
                nums2[tail2--];
        }

        // only need to combine with remaining nums2
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }

}
