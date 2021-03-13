package src.Leetcode.Problems;

import java.util.ArrayList;
import java.util.List;

import src.Util.TreeNode;

public class LC113PathSum2 {

  // Space (N) - N is the number of nodes store while traverse through stack
  // Time (N) - Traverse through the whole tree N is the number of nodes traversed
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(root, targetSum, result, path);
    return result;
  }

  private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
    if (root == null)
      return;

    path.add(root.val);

    if (root.val == targetSum && root.left == null && root.right == null) {
      result.add(new ArrayList<>(path));
    } else {
      dfs(root.left, targetSum - root.val, result, path);
      dfs(root.right, targetSum - root.val, result, path);
    }

    // To back track previous node since this already got the number, remove that
    // last index in path
    path.remove(path.size() - 1);
  }
}
