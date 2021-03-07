package src.Leetcode.Companies.Microsoft;

import src.Util.TreeNode;

public class DistanceBetween2NodesInBST {

    /**
     * Write a function that given a BST, it will return the distance (number of edges) between 2 nodes.
     * For example, given this tree
     * getDistant(5, 1, 8) -> 6. 
             5
            / \
           3   6
          / \   \
         2   4   7
        /         \
       1           8
     */

    // Space (N) - Time (Log N)
    public int getDistant(TreeNode root, int a, int b) {

        // Find lowest Common Ancestor between a and b
        root = getLCA(root, a, b);
        int result = 0;

        // Traverse down from LCA to a
        result += Traverse(root, a);
        // Traverse down from LCA to b
        result += Traverse(root, b);
        return result;
    }

    // Traverse from a root location to Node with val given
    // Space (1) - Time (Log N) - Only traverse down to the correct side of the tree because of target
    private int Traverse(TreeNode root, int target)  {
        int distance = 0;
        while (root != null && root.val != target) {
            if (root.val < target) root = root.left;
            if (root.val > target) root = root.right;
            distance++;
        }
        return distance;
    }

    // Find lowest Common Ancestor between a and b
    // Space (N) - Time (Log N)
    private TreeNode getLCA(TreeNode root, int a, int b) {
        // Both on left side
        if (a < root.val && b < root.val) {
            return getLCA(root.left, a, b);
        }
        // Both on right side
        else if (a > root.val && b > root.val) {
            return getLCA(root.right, a, b);
        }
        return root;
    }

}
