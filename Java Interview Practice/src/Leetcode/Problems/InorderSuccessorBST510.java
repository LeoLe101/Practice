package src.Leetcode.Problems;

import src.Util.Node;

public class InorderSuccessorBST510 {
    public Node inorderSuccessor(Node node) {
        if (node.right != null)
            return TraverseDown(node.right);
        if (node.parent != null)
            return TraverseUp(node.parent, node);

        return null;
    }

    public Node TraverseDown(Node child) {
        if (child.left != null)
            return TraverseDown(child.left);
        return child;
    }

    public Node TraverseUp(Node parent, Node node) {

        if (parent.val > node.val)
            return parent;
        else if (parent.parent != null)
            return TraverseUp(parent.parent, node);
        else
            return null;
    }
}
