import java.util.*;

/**
 * TwoSum
 */
public class AlgoBinaryTree {
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

    public static List<Integer> branchSum(BinaryTree root) {
        ArrayList<Integer> arr = new ArrayList<>();
        return helper(root, arr, 0);
    }

    private static ArrayList<Integer> helper(BinaryTree root, ArrayList<Integer> arr, int sum) {

    }

}