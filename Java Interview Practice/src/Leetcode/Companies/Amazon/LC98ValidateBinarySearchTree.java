package src.Leetcode.Companies.Amazon;

import java.util.Deque;
import java.util.LinkedList;

import src.Util.TreeNode;

public class LC98ValidateBinarySearchTree {

    /**
     * Space (N): Worst case when the whole Tree turn into a linkedlist
     * 
     * Time (N): Have to traverse through all the nodes within the tree N is the
     * number of nodes.
     */
    public boolean isValidDFS(TreeNode root) {
        return dfs(root, null, null);
    }

    /**
     * Ex: [5, 4, 6, null, null, 3, 7] the sub tree [6, 3, 7] is a valid BST, but
     * not valid for right branch BST if 5 is root
     * 
     * Step 1: Traverse down from 5 - 4 (min = null, max = 5) Check max != null and
     * if 4 >= 5 (Pass) - Skip min since min == null Traverse down from 4 to null on
     * both left and right, pop stack with TRUE Step 2: Traverse down from 5 - 6
     * (min = 5, max = null) Check min != null and if 6 <= 5 (Pass) - Skip max since
     * max == null Step 3: Traverse down from 6 - 3 (min = 5, max = 6) - Keep last
     * min Check max != null and if 3 >= 6 (Pass) Check min != null and if 3 <= 5
     * (Fail) Step 4: Pop stack with FALSE for right branch of 5 ==> Whole Tree
     * Invalid
     */
    private boolean dfs(TreeNode curr, Integer min, Integer max) {
        if (curr == null)
            return true;

        // Check if valid
        if (max != null && curr.val >= max || min != null && curr.val <= min)
            return false;

        // Check if next sub tree in the right BST range
        return dfs(curr.left, min, curr.val) && dfs(curr.right, curr.val, max);
    }

    // Same as above but use DFS iteratively
    public boolean isValidIterative(TreeNode root) {
        if (root == null)
            return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prevNode = null;

        while (!stack.isEmpty() && root.right != null) {

            // Move until the last left node of this branch
            while (root.left != null) {
                stack.push(root);
                root = root.left;
            }

            // Get the root from stack
            root = stack.pop();

            // Check validation
            if (prevNode != null && root.val <= prevNode.val)
                return false;

            // Make this node as prevNode
            // So when on left side, the prevNode (child node) will be compare with current root (parent node) because stack pop
            // And when on right side, the prevNode (parent node) will be compare with current root (childe node) because stack pop
            prevNode = root;

            // Move to the right node of this branch as left is already null
            // This is needed to continously add all left node into stack
            // If there is not left node, just get the root node from stack
            root = root.right;
        }

        return true;
    }
}
