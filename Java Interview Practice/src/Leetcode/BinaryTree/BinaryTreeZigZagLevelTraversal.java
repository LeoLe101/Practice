package src.Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class BinaryTreeZigZagLevelTraversal {

    public List<List<Integer>> zigzagLevelOrderRecur(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        return zigzagHelper(root, result);
    }

    public List<List<Integer>> zigzagHelper(TreeNode root, List<List<Integer>> list) {
        if (root == null)
            return list;
    }

    // Iterative Solution with Space and Time (N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Init var
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        boolean flipFlag = false;

        // Add Root to Q
        q.add(root);

        // Loop thru Q until empty
        while (!q.isEmpty()) {
            // Init var
            int size = q.size();
            ArrayList<Integer> currList = new ArrayList<>(); // Can use LL here as an optimization instead of array since capacity and re-allocation issue in array.

            // Put each nodes in curr level into the list
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (flipFlag) {
                    currList.add(curr.val);
                } else {
                    currList.add(0, curr.val);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
            flipFlag = !flipFlag;
            result.add(currList);
        }
        return result;
    }

}
