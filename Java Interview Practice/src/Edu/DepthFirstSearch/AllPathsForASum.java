package src.Edu.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import src.Util.TreeNode;

public class AllPathsForASum {

  public List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(root, sum, result, path);
    return result;
  }

  private void dfs(TreeNode curr, int sum, List<List<Integer>> result, List<Integer> path) {
    if (curr == null) {
      return;
    }

    path.add(curr.val);

    // Found the path and this node is the last node
    if (curr.val == sum && curr.left == null && curr.right == null) {
      // Need to create a new ArrayList or else it will use the same ref of path for
      // all vals
      result.add(new ArrayList<>(path));
    } else {
      dfs(curr.left, sum - curr.val, result, path);
      dfs(curr.right, sum - curr.val, result, path);
    }

    // Remove the last node in path to back track another path
    path.remove(path.size() - 1);
  }
}

// EDU SOLUTION
/**
 * Time complexity # The time complexity of the above algorithm is O(N^2), where
 * ‘N’ is the total number of nodes in the tree. This is due to the fact that we
 * traverse each node once (which will take O(N)), and for every leaf node, we
 * might have to store its path (by making a copy of the current path) which
 * will take O(N).
 * 
 * We can calculate a tighter time complexity of O(NlogN) from the space
 * complexity discussion below.
 * 
 * Space complexity # If we ignore the space required for the allPaths list, the
 * space complexity of the above algorithm will be O(N) in the worst case. This
 * space will be used to store the recursion stack. The worst-case will happen
 * when the given tree is a linked list (i.e., every node has only one child).
 * 
 * How can we estimate the space used for the allPaths array? Take the example
 * of the following balanced tree:
 *                 
 *                1
 *              /   \
 *             2     3
 *           /  |   |  \
 *          4   5   6   7
 * 
 * Here we have seven nodes (i.e., N = 7). Since, for binary
 * trees, there exists only one path to reach any leaf node, we can easily say
 * that total root-to-leaf paths in a binary tree can’t be more than the number
 * of leaves. As we know that there can’t be more than (N+1)/2 leaves in
 * a binary tree, therefore the maximum number of elements in allPaths will be
 * O((N+1)/2) = O(N). Now, each of these paths can have many
 * nodes in them. For a balanced binary tree (like above), each leaf node will
 * be at maximum depth. As we know that the depth (or height) of a balanced
 * binary tree is O(logN)O(logN) we can say that, at the most, each path can
 * have logNlogN nodes in it. This means that the total size of the allPaths
 * list will be O(N*logN). If the tree is not balanced, we will still
 * have the same worst-case space complexity.
 * 
 * From the above discussion, we can conclude that our algorithm’s overall space
 * complexity is O(N*logN).
 * 
 * Also, from the above discussion, since for each leaf node, in the worst case,
 * we have to copy log(N) nodes to store its path; therefore, the time
 * complexity of our algorithm will also be O(N*logN).
 */
class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<Integer>();
    findPathsRecursive(root, sum, currentPath, allPaths);
    return allPaths;
  }

  private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
      List<List<Integer>> allPaths) {
    if (currentNode == null)
      return;

    // add the current node to the path
    currentPath.add(currentNode.val);

    // if the current node is a leaf and its value is equal to sum, save the current
    // path
    if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
      allPaths.add(new ArrayList<Integer>(currentPath));
    } else {
      // traverse the left sub-tree
      findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
      // traverse the right sub-tree
      findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
    }

    // remove the current node from the path to backtrack,
    // we need to remove the current node while we are going up the recursive call
    // stack.
    currentPath.remove(currentPath.size() - 1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}
