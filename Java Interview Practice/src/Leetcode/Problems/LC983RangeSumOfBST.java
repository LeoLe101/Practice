package src.Leetcode.Problems;

import java.util.Deque;
import java.util.LinkedList;

import src.Util.TreeNode;

public class LC983RangeSumOfBST {

    // Space (H) - Time (N) N is number of nodes in Tree and H is the height of Tree
    // This go thru whole Tree and all Nodes
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (root.val >= low && root.val <= high) {
            return root.val + (rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high));
        }
        return (rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high));
    }

    // Space (H) - Time (N) N is number of nodes in Tree and H is the height of Tree
    // This exclude the branch that is not within range == Faster Algo
    public int rangeSumBSTV2(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        if (root.val < low) {
            return rangeSumBSTV2(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBSTV2(root.left, low, high);
        }
        return root.val + rangeSumBSTV2(root.left, low, high);
    }

    // Space (N) - Time (N)
    // Iterative with DFS Stack
    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.poll();
            if (curr == null) continue;

            if (curr.val < high) 
                stack.push(curr.right);
            if (curr.val > low)
                stack.push(curr.left);
            if (curr.val <= high && curr.val >= low)
                result += curr.val;
        }
        return result;
    }
}
