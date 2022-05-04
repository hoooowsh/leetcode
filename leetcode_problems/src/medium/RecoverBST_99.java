package medium;

import java.util.ArrayList;

import easy.SameTree_100.TreeNode;

public class RecoverBST_99 {

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
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(3);
		p.right = null;
		p.left.left = null;
		p.left.right = new TreeNode(2);
		recoverTree2(p);
		System.out.println(p.left.val);
	}

	// first version, in-order traversal. First get all nodes of a BST and store it
	// in an arraylist inorder, then see if there are two nodes in the list that is
	// not inorder, then swap it.
	public static void recoverTree1(TreeNode root) {
		// using an arraylist to store all nodes, check if all elements in order
		ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
		inorderTrav1(root, arr);
		int firstpos = 0;
		boolean boo = false;
		int secondpos = 0;
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).val > arr.get(i + 1).val && boo == false) {
				boo = true;
				firstpos = i;
			}
			if (arr.get(i).val > arr.get(i + 1).val && boo == true) {
				secondpos = i + 1;
			}
		}
		int tem = arr.get(firstpos).val;
		arr.get(firstpos).val = arr.get(secondpos).val;
		arr.get(secondpos).val = tem;
		return;
	}

	// This is a helper that getting nodes of BST from left bottom to right bottom,
	// meaning smaller to bigger.
	public static void inorderTrav1(TreeNode root, ArrayList<TreeNode> arr) {
		if (root == null) {
			return;
		}
		inorderTrav1(root.left, arr);
		arr.add(root);
		inorderTrav1(root.right, arr);
	}

	// Second version, not storing all nodes in a list and no sorting, but remember
	// it using global vars and swap it later
	static TreeNode prev;
	static TreeNode t1;
	static TreeNode t2;

	public static void recoverTree2(TreeNode root) {
		inorderTrav2(root);
		int tem = t1.val;
		t1.val = t2.val;
		t2.val = tem;
	}

	public static void inorderTrav2(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTrav2(root.left);
		if (prev != null && root.val < prev.val) {
			if (t1 == null) {
				t1 = prev;
			}
			t2 = root;
		}
		prev = root;
		inorderTrav2(root.right);
	}
}
