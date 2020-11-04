package src.Leetcode.Problems;

import src.Util.TreeNode;

public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // If the sum is not reached
        if (root == null)
            return false;

        // Check if this is the leaf node and the sum is reached
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;

        // Calculate the Sum
        sum -= root.val;

        // As long as there is 1 True, there will always be true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
