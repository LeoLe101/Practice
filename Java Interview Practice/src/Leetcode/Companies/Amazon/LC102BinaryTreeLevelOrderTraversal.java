package src.Leetcode.Companies.Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102BinaryTreeLevelOrderTraversal {

    // Space (N) - Time (N)
    // BFS version of Level Order
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        q.add(root);

        while (!q.isEmpty()) {
            LinkedList<Integer> childs = new LinkedList<>();
            int size = q.size();
            // Add the whole level into current childs
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

                childs.add(curr.val);
            }

            // Add the level to the result
            result.add(childs);
        }
        return result;
    }

    // Space (N) - Time (N)
    // DFS version of Level Order
    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        dfsHelper(result, root, 0);
        return result;
    }

    private void dfsHelper(List<List<Integer>> result, TreeNode curr, int treeHeight) {
        if (curr == null)
            return;
        if (treeHeight == result.size())
            result.add(new LinkedList<>());

        // Get the correct height of the tree and add curr TreeNode to it
        result.get(treeHeight).add(curr.val);

        dfsHelper(result, curr.left, treeHeight + 1);
        dfsHelper(result, curr.right, treeHeight + 1);
    }

}