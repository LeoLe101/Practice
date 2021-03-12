package src.Leetcode.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class LC107BinaryTreeLevelOrderTraversal2 {

  // Space (N): The space complexity of the above algorithm will be O(N)O(N) as we
  // need to return a list containing the level order traversal. We will also need
  // O(N)O(N) space for the queue. Since we can have a maximum of N/2N/2 nodes at
  // any level (this could happen only at the lowest level), therefore we will
  // need O(N)O(N) space to store them in the queue.
  
  // Time (N): loop through all
  public List<List<Integer>> levelOrderBottom(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int size = 0;

    while (!q.isEmpty()) {

      size = q.size();
      List<Integer> currLevel = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();
        currLevel.add(curr.val);

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }
      }

      result.add(0, currLevel);
    }
    return result;
  }

}
