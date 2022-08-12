package easy;

public class ConvertSortedArraytoBST_108 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		int[] arr = { -10, -3, 0, 5, 9 };
		TreeNode test = sortedArrayToBST(arr);
		System.out.println(test.val);
	}

	// using BST kind of thing
	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = new TreeNode();
		int mid = (nums.length - 1) / 2;
		root.val = nums[mid];
		helper(0, mid - 1, nums, root, true);
		helper(mid + 1, nums.length - 1, nums, root, false);
		return root;
	}

	public static void helper(int start, int end, int[] nums, TreeNode current, boolean left) {
		if (start > end) {
			return;
		}
		int mid = start + (end - start) / 2;
		TreeNode temp = new TreeNode(nums[mid]);
		if (left) {
			current.left = temp;
		} else {
			current.right = temp;
		}
		helper(start, mid - 1, nums, temp, true);
		helper(mid + 1, end, nums, temp, false);

	}
}
