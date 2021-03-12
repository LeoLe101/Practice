package src.Edu.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

import src.Util.TreeNode;

public class LevelOrderSuccessor {

  // Space (N) - Time (N)
  public TreeNode findSuccessor(TreeNode root, int key) {
    if (root == null)
      return null;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int size = 0;
    boolean isSuccessor = false;

    while (!q.isEmpty()) {
      size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = q.poll();

        if (isSuccessor)
          return curr;

        if (curr.val == key) {
          isSuccessor = true;
        }

        if (curr.left != null) {
          q.offer(curr.left);
        }
        if (curr.right != null) {
          q.offer(curr.right);
        }
      }
    }
    return null;
  }

  // Space (N) - Time (N)
  public static TreeNode findSuccessorEDU(TreeNode root, int key) {
    if (root == null)
      return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    // Do not actually need to traverse until this layer is over.
    // Just traverse like usual is ok.
    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      // insert the children of current node in the queue
      if (currentNode.left != null)
        queue.offer(currentNode.left);
      if (currentNode.right != null)
        queue.offer(currentNode.right);

      // break if we have found the key
      if (currentNode.val == key)
        break;
    }

    return queue.peek();
  }

}
