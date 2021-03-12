package src.Edu.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class BinaryTreeLevelOrder {

  public List<List<Integer>> traverse(TreeNode root) {

    if (root == null)
      return new ArrayList<>();

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int size = 0;

    while (!q.isEmpty()) {
      size = q.size();
      List<Integer> currLevel = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }

        currLevel.add(curr.val);
      }

      result.add(currLevel);
    }
    return result;
  }

  // Q:
  // size: 2
  // CurrLevl [15, 7]
  // result [3], [9, 20], [15, 7]
}
