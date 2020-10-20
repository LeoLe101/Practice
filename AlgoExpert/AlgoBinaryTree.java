import java.util.ArrayList;

// Usually if you cannot do recursion, and the Binary Tree required some manipulation
// There will definitely a Stack/Queue involved.
// Level Traversal use BFS
// Depth Traversal use DFS
public class AlgoBinaryTree {

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // #region Branch Sum
    // Time (N) - Space (N) due to recursion stack
    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        return helperBranchSum(arr, root, 0);
    }

    private static ArrayList<Integer> helperBranchSum(ArrayList<Integer> arr, BinaryTree currNode, int sum) {

        sum += currNode.value;

        if (currNode.left != null) {
            arr = helperBranchSum(arr, currNode.left, sum);
        }

        if (currNode.right != null) {
            arr = helperBranchSum(arr, currNode.right, sum);
        }

        if (currNode.left == null && currNode.right == null)
            arr.add(sum);
        return arr;
    }
    // #endregion

    // #region Node Depths
    // Recursion version Time (N) - Space (h) with H is the height of Tree
    // N is the number of Node in Tree
    public static int nodeDepths(BinaryTree root) {
        if (root == null)
            return -1;
        return helperNodeDepths(root, 0);
    }

    private static int helperNodeDepths(BinaryTree currNode, int sum) {
        if (currNode == null)
            return 0;
        int leftHeight = helperNodeDepths(currNode.left, sum + 1);
        int rightHeight = helperNodeDepths(currNode.right, sum + 1);
        return sum + leftHeight + rightHeight;
    }
    // #endregion

    // #region Invert Binary Tree
    // Recursion version Time (N) - Space (h) with H is the height of the Tree
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null)
            return;
        swapTreeNode(tree, tree.left, tree.right);

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    private static void swapTreeNode(BinaryTree curr, BinaryTree left, BinaryTree right) {
        curr.left = right;
        curr.right = left;
    }
    // #endregion
}