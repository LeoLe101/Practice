import java.util.LinkedList;
import java.util.Queue;


public class SymmetricTree101 {
    //#region Not Fully covered all the problems, Still not correct
    public Queue<Integer> q = new LinkedList<Integer>();

    public boolean isSymmetric(TreeNode root) {
        TraverseLeft(root.left);
        return TraverseRight(root.right);
    }

    private void TraverseLeft(TreeNode leftChild) {
        if (leftChild.left != null)
            TraverseLeft(leftChild.left);
        if (leftChild.right != null)
            TraverseLeft(leftChild.right);
        q.add(leftChild.val);
    }

    private boolean TraverseRight(TreeNode rightChild) {
        boolean result = false;
        if (rightChild.right != null)
            result = TraverseRight(rightChild.right);
        if (result && rightChild.left != null)
            TraverseRight(rightChild.left);
        
        int curr = q.isEmpty() ? Integer.MIN_VALUE : q.poll(); 

        return curr == rightChild.val;

    }

    //#endregion

    //#region Most Optimized Recursion Solution
    public boolean isSymmetricOptimized(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }
    
    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
    //#endregion

}
