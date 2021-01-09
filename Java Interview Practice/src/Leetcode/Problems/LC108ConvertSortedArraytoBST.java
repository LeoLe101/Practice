package src.Leetcode.Problems;

import src.Util.TreeNode;

public class LC108ConvertSortedArraytoBST {
    // Space (N) Time (N)
    public TreeNode sortedArrayToBSTRecur(int[] nums) {
        if (nums.length < 1) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int leftIdx, int rightIdx) {

        if (leftIdx > rightIdx) return null;

        // Find the middle index
        int midIdx = leftIdx + (rightIdx - leftIdx)/2;
        TreeNode curr = new TreeNode(midIdx);

        // Recur and add child node to this currNode 
        curr.left = helper(nums, leftIdx, midIdx - 1);
        curr.right = helper(nums, midIdx + 1, rightIdx);
        return curr;
    }
}



