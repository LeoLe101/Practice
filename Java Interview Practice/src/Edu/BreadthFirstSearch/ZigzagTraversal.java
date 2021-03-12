package src.Edu.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class ZigzagTraversal {

  // Space (N) - Time (N)
  public List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null)
      return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int size = 0;
    int level = 1; // or boolean isLeftToRight = true;

    while (!q.isEmpty()) {
      size = q.size();
      ArrayList<Integer> currLvl = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }

        if (level % 2 == 0) { // or if (!isLeftToRight) {
          currLvl.add(0, curr.val);
        } else {
          currLvl.add(curr.val);
        }
      }
      result.add(currLvl);
      level++; // or isLeftToRight = !isLeftToRight;
    }

    return result;
  }

}
