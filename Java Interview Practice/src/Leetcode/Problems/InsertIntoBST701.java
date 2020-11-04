package src.Leetcode.Problems;

import src.Util.TreeNode;

public class InsertIntoBST701 {

    // Kinda Optimized but still not good as this is not clean code
    // Space and Time O(Log N) for best and O(N) for worst
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val && root.left != null)
            Traverse(root.left, val);
        else if (root.val < val && root.right != null)
            Traverse(root.right, val);
        else if (root.val > val && root.left == null)
            root.left = new TreeNode(val);
        else
            root.right = new TreeNode(val);
        return root;
    }

    private void Traverse(TreeNode curr, int val) {
        if (curr == null) {
            curr = new TreeNode(val);
            return;
        }
        if (curr.left != null && val < curr.val) {
            Traverse(curr.left, val);
            return;
        }
        if (curr.right != null && val > curr.val) {
            Traverse(curr.right, val);
            return;
        }

        if (val < curr.val) {
            curr.left = new TreeNode(val);
        } else {
            curr.right = new TreeNode(val);
        }
    }

    // Clean/Optimized version
    // Space and Time O(Log N) for best and O(N) for worst
    public TreeNode inserIntoBSTOptimized(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = inserIntoBSTOptimized(root.left, val);
        else
            root.right = inserIntoBSTOptimized(root.right, val);

        return root;
    }

    // Iteration version. The Time is the same as the one above
    // Space is O(1) since there is no need of keeping track in stack for recursion
    public TreeNode insertIntoBSTIteration(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.val) {
                // insert right now
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else
                    node = node.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else
                    node = node.left;
            }
        }
        return new TreeNode(val);
    }
}
