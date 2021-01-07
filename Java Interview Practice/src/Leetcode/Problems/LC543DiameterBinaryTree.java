package src.Leetcode.Problems;

import src.Util.TreeNode;

public class LC543DiameterBinaryTree {

    // Space (N) Time (N)
    public int diamaeterOfBinaryTree(TreeNode root) {
        return helperTreeDepth(root.left) + helperTreeDepth(root.right);
    }

    // This is find the depth of the Tree, We need to find the Diameter of the
    // Binary Tree instead! 
    // Which means traverse and find the deepest child of both left and right child
    // Then combine them together
    private int helperTreeDepth (TreeNode curr) {

        if (curr == null) return 0;

        int left = helperTreeDepth(curr.left) + 1;
        int right = helperTreeDepth(curr.right) + 1;

        return Math.max(left, right);
    }
}
