package src.Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import src.Util.TreeNode;

//ore https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreorderTraversal {

    // Space (N) Time (N)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>(); // Should use LL here instead of ArrayList because Arraylist has to re-allocate the structure, where LL just change the reference
        return preorderHelper(root, list);
    }

    public List<Integer> preorderHelper(TreeNode curr, List<Integer> list) {
        if (curr == null) return list;

        list.add(curr.val);
        list = preorderHelper(curr.left, list);
        list = preorderHelper(curr.right, list);

        return list;
    }

    // Iterative version
    // Space (N) Time (N)
    public List<Integer> preorderTraversalIter(TreeNode node) {``
        // Result of current pre-order (meant to keep track left node)
        List<Integer> list = new LinkedList<Integer>();
        // Keep track of the right node of curr node
        Stack<TreeNode> rights = new Stack<TreeNode>();

        while(node != null) {
            list.add(node.val);

            // If right, record it in stack
            if (node.right != null) {
                rights.push(node.right);
            }

            // Go down left
            node = node.left;

            // If left null and right of the parent node is not, move curr node to that right node
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }
}
