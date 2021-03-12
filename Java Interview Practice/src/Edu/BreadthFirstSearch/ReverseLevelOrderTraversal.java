package src.Edu.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class ReverseLevelOrderTraversal {

  // Space (N) - Time (N): Similar to the Binary Level Order 
  // but instead of adding the new array at the last 
  // of the result, now add at the front
  public List<List<Integer>> traverse(TreeNode root) {

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
