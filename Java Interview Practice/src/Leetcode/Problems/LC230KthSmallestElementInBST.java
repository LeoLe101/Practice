package src.Leetcode.Problems;

import java.util.Deque;
import java.util.LinkedList;

import src.Util.TreeNode;

public class LC230KthSmallestElementInBST {

    private int result = 0;
    private int count = 0;

    /**
     * Space (N) Time (N) - because have stack recursion to traverse through all the tree if k = N
     */
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfsHelper(root);
        return result;
    }

    private void dfsHelper(TreeNode curr) {
        if (curr == null || count == 0)
            return;

        dfsHelper(curr.left);

        if (count > 0) {
            count--;
            result++;
        }

        dfsHelper(curr.right);

    }

    public int kthSmallestDFSIterative(TreeNode root, int k) {
        if (root == null)
            return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        int result = 0;

        while (root != null || !stack.isEmpty()) {

            // Put all the left node of the branch
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            k--;
            if (k == 0) {
                result = root.val;
                break;
            } 
            root = root.right;
        }
        return result;
    }

}
