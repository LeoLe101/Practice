package src.Leetcode.Companies.Amazon;

import src.Util.TreeNode;

public class LC543DiameterOfBinaryTree {
    
    private int result = 0;

    /**
     * Space (N) - Recursion stack
     * Time (N) - with n is the number of node traversed
     */
    public int diameterOfBinaryTree(TreeNode root) {
        dfsTraversal(root);
        return result;
    }

    private int dfsTraversal(TreeNode curr) {
        if (curr == null) return 0;

        int left = dfsTraversal(curr.left);
        int right = dfsTraversal(curr.right);

        result = Math.max(left + right, result);

        return Math.max(left, right) + 1;
    }
}
