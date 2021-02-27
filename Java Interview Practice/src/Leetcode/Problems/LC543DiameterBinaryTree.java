package src.Leetcode.Problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import src.Util.TreeNode;

public class LC543DiameterBinaryTree {

    // #region Recursion
    private int max = 0;

    // Space (N) Time (N)
    public int diamaeterOfBinaryTree(TreeNode root) {
        helperTreeDepth(root);
        return max;
    }

    // This is find the depth of the Tree, We need to find the Diameter of the
    // Binary Tree instead!
    // Which means traverse and find the deepest child of both left and right child
    // Then combine them together
    private int helperTreeDepth(TreeNode curr) {
        if (curr == null)
            return 0;

        // Recursively traverse through left and right branch
        int left = helperTreeDepth(curr.left);
        int right = helperTreeDepth(curr.right);

        // Update max value with the curr Diameter found
        max = Math.max(max, left + right + 1); // Because max is decided and returned as a global val, do not need to
                                               // care
        // of the first root is null or not.

        // Return the branch that is deeper/longer
        return Math.max(left, right) + 1;
    }
    // #endregion

    // #region Iteration

    // Use stack to traverse until the deepest node of the tree
    // Use map to keep track of each node's max diameter (Using that node as the
    // root for current path of left and right)
    // Space(N) - Time(N)
    public int diameterOfBinaryTreeIter(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        int diameter = 0;

        // Only add to stack if not null
        if (root != null)
            stack.push(root);

        // Until stack is not empty, traverse through the tree and add into stack
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            // Add into stack when left or right is not null and not in the map yet
            if (node.left != null && !map.containsKey(node.left)) {
                stack.offer(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.offer(node.right);
            } else {
                // Reached the deepest part, pop curr node
                stack.pop();

                // Check/get the depth of left and right
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);

                // Change the value of current node to the max branch value between left and right
                map.put(node, 1 + Math.max(leftDepth, rightDepth));

                // Update max diameter
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }
        return diameter;
    }
    // #endregion
}
