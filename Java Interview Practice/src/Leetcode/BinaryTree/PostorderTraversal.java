package src.Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.List;

import src.Util.TreeNode;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        return helperTraversal(root, result);
    }

    private List<Integer> helperTraversal(TreeNode curr, List<Integer> list) {

        if (curr == null) {
            return list;
        }

        list = helperTraversal(curr.left, list);
        list = helperTraversal(curr.right, list);

        list.add(curr.val);
        return list;

    }

}
