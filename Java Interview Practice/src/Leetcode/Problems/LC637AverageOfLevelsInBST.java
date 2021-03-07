package src.Leetcode.Problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class LC637AverageOfLevelsInBST {

    // Space (N) - Time (N * K) with K is the size of that specific Queue
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> result = new LinkedList<Double>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Loop through the Queue
        while (!q.isEmpty()) {
            int size = q.size();
            Double currAvg = 0.0;

            // Loop all the nodes added for this level and calculate the sum
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currAvg += curr.val;
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            result.add(currAvg / size);
        }
        return result;
    }

    // Space (N) - Time (N)
    public List<Double> averageOfLevelsDFS(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Double> result = new LinkedList<>();
        int sum = 0;


    }

    private void dfsHelper(TreeNode curr, int level, List<Double> list) {
        

    }

}
