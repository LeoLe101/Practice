package src.Leetcode.Problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import src.Util.TreeNode;

public class LC226InvertBinaryTree {

    // Space (N) - Time (N)
    // BFS with Queue version. This will help the application easier to scale
    // because Queue DS instead of Stack
    public TreeNode invertTreeBFS(TreeNode root) {

        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();

            // If right available, add to Queue
            if (currNode.right != null)
                q.offer(currNode.right);
            // If left available, add to Queue after right
            if (currNode.left != null)
                q.offer(currNode.left);

            // Swap current location of left and right in the currTree
            TreeNode temp = currNode.left;
            currNode.left = currNode.right;
            currNode.right = temp;
        }

        return root;
    }

    // Space (N) - Time (N)
    // DFS with Stack version (Iterative). Not easy to scale in the future.
    public TreeNode invertTreeDFSIterative(TreeNode root) {

        if (root == null)
            return null;

        // Use Deque instead of Stack because it is more consistent
        // Interface is easier to implement compare to just inheriting 1 class.
        // Stack is using Vector, which cost performance issues in the future
        Deque<TreeNode> s = new LinkedList<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode curr = s.poll();

            // Add left before right because STACK DS
            if (curr.left != null)
                s.offer(curr.left);
            if (curr.right != null)
                s.offer(curr.right);

            // Swap current location of left and right in the currTree
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }
        return root;
    }

    // Space (N) - Time (N)
    public TreeNode invertTreeDFSRecursion(TreeNode root) {
        if (root == null)
            return null;

        // Recur down until hit the leaves nodes
        invertTreeDFSRecursion(root.left);
        invertTreeDFSRecursion(root.right);

        // Swap this node's childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    // More elegant
    public TreeNode invertTreeDFSRecursionV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeDFSRecursionV2(root.right);
        TreeNode left = invertTreeDFSRecursionV2(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
