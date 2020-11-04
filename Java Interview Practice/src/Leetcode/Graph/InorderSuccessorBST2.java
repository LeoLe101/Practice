package src.Leetcode.Graph;

import src.Util.Node;

public class InorderSuccessorBST2 {

    public Node inorderSuccessor(Node node) {
        if (node.right != null)
            return TraverseDown(node.right, node);
        return null;
    }

    public Node TraverseDown(Node child, Node node) {
        if (child.left != null)
            TraverseDown(child.left, node);
        if (child.right != null)
            TraverseDown(child.right, node);
        if (child.val > node.val)
            return child;
        return null;
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
