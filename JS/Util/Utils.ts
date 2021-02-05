
export class TreeNode {

    public val: number;
    public left: TreeNode;
    public right: TreeNode;

    public constructor(val, left, right) {
        this.val = (val === undefined ? 0 : val)
        this.left = (val === undefined ? 0 : left)
        this.right = (val === undefined ? 0 : right)
    }
}