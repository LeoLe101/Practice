package src.Edu.DepthFirstSearch;

import src.Util.TreeNode;

public class BinaryTreePathSum {

  // Space (N )
  public boolean hasPathRecur(TreeNode root, int sum) {
    if (root == null)
      return false;

    // found the number, but make sure this is the last node
    if (root.val == sum && root.left == null && root.right == null)
      return true;

    sum -= root.val;

    // Return true of 1 of the branch return true;
    return hasPathRecur(root.left, sum) || hasPathRecur(root.right, sum);
  }
}

// EDU SOLUTION
/**
 * Time complexity # The time complexity of the above algorithm is O(N), where
 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
 * traverse each node once.
 * 
 * Space complexity # The space complexity of the above algorithm will be O(N)
 * in the worst case. This space will be used to store the recursion stack. The
 * worst case will happen when the given tree is a linked list (i.e., every node
 * has only one child).
 */
class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {
    if (root == null)
      return false;

    // if the current node is a leaf and its value is equal to the sum, we've found
    // a path
    if (root.val == sum && root.left == null && root.right == null)
      return true;

    // recursively call to traverse the left and right sub-tree
    // return true if any of the two recursive call return true
    return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
  }
}
