package src.Leetcode.Companies.Amazon;

import src.Util.TreeNode;

public class LC101SymmetricTree {

  /**
   * Space (N) due to the stack needed for the recursion
   * 
   * Time (N) traverse through all the node within the tree
   */
  public boolean isSymmetric(TreeNode root) {
    return root == null || helper(root.left, root.right);
  }

  private boolean helper(TreeNode left, TreeNode right) {
    if (left == null || right == null)
      return left == right;
    if (left.val != right.val)
      return false;
    return helper(left.left, right.right) && helper(left.right, right.left);
  }
}