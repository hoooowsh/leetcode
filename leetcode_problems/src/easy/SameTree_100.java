package easy;

public class SameTree_100 {
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
		p.left = new TreeNode(2);
		TreeNode q = new TreeNode(1);
		q.left = null;
		q.right = new TreeNode(2);
		System.out.println(isSameTree(null, null));
	}

	// using recursion, DFS or BFS also can be used
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static boolean isSameTree2(TreeNode p, TreeNode q) {
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		} else if (p == null && q == null) {
			return true;
		} else if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
