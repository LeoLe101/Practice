package src.Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.CyclicBarrier;

import src.Util.TreeNode;

public class LC104MaximumDepthOfBinaryTree {

    // Space(N) Time(N)
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        // Traverse down to the leave nodes, increase 1 everytime going up;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS with Queue - Find level of the Node
    // Space (N) Time (N)
    public int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();

            // Add all nodes of each Layer into the Queue
            while (size > 0) {
                TreeNode currNode = q.poll();
                size--;
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            // Once all the child nodes are added into the Queue, increase level counter
            level++;
        }
        return level;
    }

    // DFS with Stack - Find Level of the Node
    // Space (N) Time (N)
    public int maxDepthDFS(TreeNode root) {
        if (root == null)
            return 0;

        int level = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> value = new Stack<Integer>();
        s.push(root);
        value.push(1);

        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            int currLevel = value.pop();
            level = Math.max(currLevel, level); // Check if the current level is more than the global level

            // Add right first because Stack DS will pop Left before right if it is addded
            if (curr.right != null) {
                s.push(curr.right);
                value.push(currLevel + 1); // Increase level by 1
            }
            if (curr.left != null) {
                s.push(curr.left);
                value.push(currLevel + 1);
            }
        }
        return level;
    }
}
