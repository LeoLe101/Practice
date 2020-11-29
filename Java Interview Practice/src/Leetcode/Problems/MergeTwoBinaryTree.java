package src.Leetcode.Problems;

import src.Util.TreeNode;

public class MergeTwoBinaryTree {

    /**
     * Recursion Time and Space: O(N)
     * @param t1 head of Tree1
     * @param t2 head of Tree2
     * @return head of modified Tree1
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // Return the child branch if one of them doesn't exist
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // If both branch exist, combine value into the tree 1
        t1.val += t2.val;

        // Traverse to the left child branch the same thing.
        t1.left = mergeTrees(t1.left, t2.left);

        // Traverse to the right child branch the same thing.
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


}
