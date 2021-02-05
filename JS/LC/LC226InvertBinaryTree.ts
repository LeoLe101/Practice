
import { TreeNode } from '../Util/Utils';

const invertTree = (root: TreeNode): TreeNode => {
    if (!root) return root;
    let right: TreeNode = invertTree(root.right);
    let left: TreeNode = invertTree(root.left);
    root.right = left;
    root.left = right;
    return root;
}