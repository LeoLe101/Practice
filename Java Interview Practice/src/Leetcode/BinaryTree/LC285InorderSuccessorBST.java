package src.Leetcode.BinaryTree;

import src.Util.TreeNode;

public class LC285InorderSuccessorBST {

    // Not Finished
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.val < root.val)
            return TraverseTree(root.left, p, false);
        return TraverseTree(root.right, p, false);
    }

    private TreeNode TraverseTree(TreeNode node, TreeNode target, boolean isSuccessorNode) {
        if (node.left != null)
            TraverseTree(node.left, target, isSuccessorNode);

        if (node.val > target.val)
            return node;

        if (node.right != null)
            TraverseTree(node.right, target, isSuccessorNode);
        
        return null;
    }
}
