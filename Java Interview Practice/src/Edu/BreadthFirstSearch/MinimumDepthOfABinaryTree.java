package src.Edu.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

import src.Util.TreeNode;

public class MinimumDepthOfABinaryTree {

  // Space (N) - Time (N)
  public int findDepth(TreeNode root) {
    int level = 0;
    if (root == null)
      return level;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int size = 0;

    while (!q.isEmpty()) {
      size = q.size();
      level++;
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        if (curr.left != null) {
          q.offer(curr.left);
        }
        if (curr.right != null) {
          q.offer(curr.right);
        }
      }
    }
    return level;
  }

}
