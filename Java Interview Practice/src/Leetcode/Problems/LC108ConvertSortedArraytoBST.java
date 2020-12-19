package src.Leetcode.Problems;

public class LC108ConvertSortedArraytoBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int midIndx = 0 + ((nums.length - 1) - 0) / 2;

        TreeNode root = new TreeNode(nums[midIndx ]);

        // Add all node from the left into the Tree
        addNodeLeft(root, nums, midIndx - 1);
        // Add all node from the right into the Tree
        addNodeRight(root, nums, midIndx + 1);

        return root;
    }

    private void addNodeLeft(TreeNode curr, int[] nums, int leftIndex) {

        if (leftIndex < 0) return;

        if (nums[rightIndex] < curr.val) {
            curr.left = new TreeNode(nums[leftIndex]);
            addNodeLeft(curr.left, nums, leftIndex--);
        } else {
            curr.right = new TreeNode(nums[leftIndex]);
            addNodeLeft(curr.right, nums, leftIndex--);
        }

        return;
    }

    private void addNodeRight(TreeNode curr, int[] nums, int rightIndex) {
        if (rightIndex < 0) return;

        if (nums[rightIndex] < curr.val) {
            curr.left = new TreeNode(nums[rightIndex]);
            addNodeRight(curr.left, nums, rightIndex++);
        } else {
            curr.right = new TreeNode(nums[rightIndex]);
            addNodeRight(curr.right, nums, rightIndex++);
        }

        return;
    }


    // Space (N) Time (N)
    public TreeNode sortedArrayToBSTRecur(int[] nums) {
        if (nums.length < 1) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int leftIdx, int rightIdx) {

        if (leftIdx > rightIdx) return null;

        // Find the middle index
        int midIdx = leftIdx + (rightIdx - leftIdx)/2;
        TreeNode curr = new TreeNode(midIdx);

        // Recur and add child node to this currNode 
        curr.left = helper(nums, leftIdx, midIdx - 1);
        curr.right = helper(nums, midIdx + 1, rightIdx);
        return curr;
    }
}



