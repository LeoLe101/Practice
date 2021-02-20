package src.Leetcode.BinaryTree;

import src.Util.TreeNode;

/**
 * NOTE: This is a BINARY TREE - which doesn't sort the tree out properly
 */
public class LC236LowestCommonAncestorOfBinaryTree {

    // Space (N) - Time (N) - With N is number of nodes in Binary Tree
    //                        because need to find p and q nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null && right == null) return left;
        return right;
    }

}
