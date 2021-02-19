package src.Leetcode.BinaryTree;

import src.Util.TreeNode;

/**
 * NOTE: This is a Binary Search Tree - Which mean smaller values will be on the
 * left side - Bigger values will be on the right side
 */
public class LC235LowestCommonAncestorOfBST {

    // Space (N) - Time (N) - Where N is the number of Nodes in BST and this is a
    // recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    // Space (1) - Time (N) Since this is an iterative
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
