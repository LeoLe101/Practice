package src.Leetcode.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class BinaryTreeZigZagLevelTraversal {

    // Space (N) - Time (N) DFS Version
    public List<List<Integer>> zigzagLevelOrderRecur(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        dfsHelper(root, result, 0);
        return result;
    }

    private void dfsHelper(TreeNode curr, List<List<Integer>> list, int height) {
        if (curr == null)
            return;
        if (height == list.size())
            list.add(new LinkedList<>());

        List<Integer> currChilds = list.get(height);

        // If the level is Even, add node from the end of the arr
        if (height % 2 == 0) currChilds.add(curr.val);
        // Else, add from the start of the arr
        else currChilds.add(0, curr.val);

        dfsHelper(curr.left, list, height + 1);
        dfsHelper(curr.right, list, height + 1);
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
            ArrayList<Integer> currList = new ArrayList<>(); // Can use LL here as an optimization instead of array
                                                             // since capacity and re-allocation issue in array.

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
