
package src.Leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC116PopulatingNextRightPointersInEachNode
 */
public class LC116PopulatingNextRightPointersInEachNode {
  public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.next = next;
    }

  }

  public Node connect(Node root) {
    if (root == null)
      return root;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    int size = 0;

    while (!q.isEmpty()) {
      size = q.size();
      while (size >= 1) {
        Node curr = q.poll();
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
    return root;
  }

}