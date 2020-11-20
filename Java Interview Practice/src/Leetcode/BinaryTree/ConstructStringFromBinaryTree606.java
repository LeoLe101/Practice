package src.Leetcode.BinaryTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import src.Util.TreeNode;

public class ConstructStringFromBinaryTree606 {

    // Recursion version Space and Time (N)
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        return treeHelper(t, "");
    }

    private String treeHelper(TreeNode curr, String result) {
        // curr is null
        if (curr == null)
            return "";

        // both childs are null
        if (curr.left == null && curr.right == null)
            return "" + curr.val;

        // By pass right child if null (Don't have to print "()")
        if (curr.right == null)
            return curr.val + "(" + treeHelper(curr.left, result) + ")";

        // Print both case;
        return curr.val + "(" + treeHelper(curr.left, result) + ")" + "(" + treeHelper(curr.right, result) + ")";
    }

    // Iterative with Stack version Space and Time (N)
    public String tree2strIter(TreeNode t) {
        if (t == null)
            return "";

        // Init var
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();

        // put root to stack
        stack.push(t);

        // Loop until Stack is empty
        while (!stack.isEmpty()) {
            t = stack.peek();

            // Check if node visited, pop out of stack is it is
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } 
            // Visit unvisited node, go down to that node left child branch then right branch
            else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}
