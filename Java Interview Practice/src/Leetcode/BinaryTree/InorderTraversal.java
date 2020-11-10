package src.Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import src.Util.TreeNode;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        return helper(root, list);
    }

    public List<Integer> helper(TreeNode curr, List<Integer> list) {

        if (curr == null)
            return list;

        if (curr.left != null) {
            list = helper(curr.left, list);
        }

        list.add(curr.val);

        if (curr.right != null) {
            list = helper(curr.right, list);
        }

        return list;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> list = new LinkedList<>();

        if (root == null)
            return list;

        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stk.isEmpty()) {

            // Traverse to the left most child node
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            // Pop from stack and put into list. Then move to the right node
            curr = stk.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
