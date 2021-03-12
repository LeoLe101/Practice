package src.Edu.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.Util.TreeNode;

public class LevelAveragesInABinaryTree {

  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double levelSum = 0;

      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        // add the node's value to the running sum
        levelSum += currentNode.val;

        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }

      // append the current level's average to the result array
      result.add(levelSum / levelSize);
    }
    return result;
  }

}
