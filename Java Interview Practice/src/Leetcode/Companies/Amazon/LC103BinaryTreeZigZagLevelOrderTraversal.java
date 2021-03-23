package src.Leetcode.Companies.Amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class LC103BinaryTreeZigZagLevelOrderTraversal {

    /**
     * Space (N) - Because needed for keeping each level and node
     * Time (N) - Loop through all the node within the tree in a zigzag manner
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();

                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }

                if (level % 2 == 0) {
                    currLevel.add(currNode.val);
                }
                else {
                    currLevel.add(0, currNode.val);
                }
            }
            result.add(currLevel);
            level++;
        }
        return result;
    }


}
