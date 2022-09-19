package medium;

import java.util.Stack;

public class SplitBST_776 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(11);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(13);
		TreeNode[] tt = splitBST(root, 12);
	}

	/**
	 * 
	 * We could easily find out that the smaller tree only update its right child.
	 * On the other hand, the larger tree always only update its left child. In each
	 * time, we have several following steps: If root is in the smaller tree:
	 * 
	 * 1. Point curSm's right child to root 2. Move curSm to its right child(root)
	 * 3. make root's right child point to null (Maybe root's right child will point
	 * to another node in the future. Maybe not. If not, it must point to null. Or
	 * there will be a node pointed by two parents.) 4. move root to its right child
	 * (Remember that we always iterate node around the split line)
	 * 
	 * ps. the current node of the smaller tree: "curSm" the current node of the
	 * larger tree: "curLg"
	 */
	public static TreeNode[] splitBST3(TreeNode root, int V) {
		TreeNode dummySm = new TreeNode(0);
		TreeNode curSm = dummySm;
		TreeNode dummyLg = new TreeNode(0);
		TreeNode curLg = dummyLg;

		while (root != null) {
			if (root.val <= V) {
				curSm.right = root;
				curSm = root;
				root = root.right;
				curSm.right = null;
			} else {
				curLg.left = root;
				curLg = root;
				root = root.left;
				curLg.left = null;
			}
		}
		return new TreeNode[] { dummySm.right, dummyLg.left };
	}

	// Binary search version
	public static TreeNode[] splitBST(TreeNode root, int target) {
		TreeNode[] result = new TreeNode[2];
		if (root == null) {
			return result;
		}

		// this while loop is recording what node is passing through
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			if (root.val > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}

		// Now checking the stack, since this approach is checking nodes from bottom to
		// top, so if curval is bigger than target, then from previous while loop, it
		// must go left, then left child of current node must be previous node in the
		// stack
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.val > target) {
				cur.left = result[1];
				result[1] = cur;
			} else {
				cur.right = result[0];
				result[0] = cur;
			}
		}
		return result;
	}

	public static TreeNode[] splitBST2(TreeNode root, int target) {
		if (root == null) {
			return new TreeNode[] { null, null };
		} else if (root.val <= target) {
			TreeNode[] bns = splitBST2(root.right, target);
			root.right = bns[0];
			bns[0] = root;
			return bns;
		} else {
			TreeNode[] bns = splitBST2(root.left, target);
			root.left = bns[1];
			bns[1] = root;
			return bns;
		}
	}

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
}
