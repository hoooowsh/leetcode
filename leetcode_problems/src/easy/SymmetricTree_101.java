package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		boolean test = isSymmetric2(root);
		System.out.println(test);
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> leftq = new LinkedList<TreeNode>();
		Queue<TreeNode> rightq = new LinkedList<TreeNode>();
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		ArrayList<Integer> arrr = new ArrayList<Integer>();

		TreeNode curleft = root.left;
		TreeNode curright = root.right;
		if (curleft != null) {
			leftq.add(curleft);
			arrl.add(curleft.val);
		}
		if (curright != null) {
			rightq.add(curright);
			arrr.add(curright.val);
		}

		while (!leftq.isEmpty()) {
			TreeNode cur = leftq.poll();
			if (cur != null) {
				leftq.add(cur.left);
				if (cur.left == null) {
					arrl.add(null);
				} else {
					arrl.add(cur.left.val);
				}
				leftq.add(cur.right);
				if (cur.right == null) {
					arrl.add(null);
				} else {
					arrl.add(cur.right.val);
				}
			}
		}
		while (!rightq.isEmpty()) {
			TreeNode cur = rightq.poll();
			if (cur != null) {
				rightq.add(cur.right);
				if (cur.right == null) {
					arrr.add(null);
				} else {
					arrr.add(cur.right.val);
				}
				rightq.add(cur.left);
				if (cur.left == null) {
					arrr.add(null);
				} else {
					arrr.add(cur.left.val);
				}
			}

		}
		if (arrl.size() != arrr.size()) {
			return false;
		}
		for (int i = 0; i < arrr.size(); i++) {
			if (arrr.get(i) == null && arrl.get(i) == null) {
				continue;
			} else if (arrr.get(i) != arrl.get(i)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSymmetric2(TreeNode root) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> leftq = new LinkedList<TreeNode>();
		Queue<TreeNode> rightq = new LinkedList<TreeNode>();
		TreeNode curleft = root.left;
		TreeNode curright = root.right;
		// making sure the first left and right are the same
		if (curleft != null && curright != null) {
			if (curleft.val != curright.val) {
				return false;
			} else {
				leftq.add(curleft);
				rightq.add(curright);
			}
		} else if (curleft == null && curright == null) {
			return true;
		} else {
			return false;
		}
		// BFS using queue, DFS using stack
		while (!leftq.isEmpty()) {
			TreeNode lcur = leftq.poll();
			TreeNode rcur = rightq.poll();
			// if both null, continue
			if (lcur == null && rcur == null) {
				continue;
			}
			// if one is null, on is not, tree not match
			else if (lcur == null && rcur != null || rcur == null && lcur != null) {
				return false;
			}
			// if not null, compare the value and make a decision
			else {
				if (lcur.val != rcur.val) {
					return false;
				} else {
					leftq.add(lcur.left);
					leftq.add(lcur.right);
					rightq.add(rcur.right);
					rightq.add(rcur.left);
				}
			}
		}
		return true;
	}

}
