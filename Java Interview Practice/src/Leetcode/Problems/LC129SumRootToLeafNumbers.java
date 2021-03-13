package src.Leetcode.Problems;

import java.util.ArrayList;
import java.util.List;

import src.Util.TreeNode;

public class LC129SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    int sum = 0;
    if (root == null)
      return sum;

    List<Integer> paths = new ArrayList<>();
    dfs(root, paths, 0);
    for (Integer pathSum : paths) {
      sum += pathSum;
    }
    return sum;
  }

  private void dfs(TreeNode root, List<Integer> paths, int sum) {
    if (root == null) return;

    sum += root.val;

    if (root.left == null && root.right == null) {
      paths.add(sum);
    } else {
      dfs(root.left, paths, sum);
      dfs(root.right, paths, sum);
    }

    sum -= root.val;
  }
}
