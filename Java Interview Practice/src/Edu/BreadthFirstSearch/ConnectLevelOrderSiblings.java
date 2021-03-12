package src.Edu.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

import src.Util.TreeNode;

public class ConnectLevelOrderSiblings {

  // Space (N) - Time (N)
  public void connect(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int size = 0;

    while (!q.isEmpty()) {
      size = q.size();
      while (size >= 1) {
        TreeNode curr = q.poll();
        if (size <= 1)
          curr.next = null;
        else {
          curr.next = q.peek();
        }

        if (curr.left != null) {
          q.offer(curr.left);
        }

        if (curr.right != null) {
          q.offer(curr.right);
        }
        size--;
      }
    }
    return;
  }

  // Space (N) - Time (N)
  public static void connectEDU(TreeNode root) {
    if (root == null)
      return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode previousNode = null;
      int levelSize = queue.size();
      // connect all nodes of this level
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        if (previousNode != null)
          previousNode.next = currentNode;
        previousNode = currentNode;

        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
    }
  }

}
