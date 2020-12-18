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
}
