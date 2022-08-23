package easy;

public class LowestCommonAncestorofBST_235 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {

	}

	// if two target all in one side, continue. If they are in different side, then
	// current node is the common ancestor
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode cur = root;
		while (true) {
			if (p.val < cur.val && q.val < cur.val) {
				cur = cur.left;
				continue;
			}
			if (p.val > cur.val && q.val > cur.val) {
				cur = cur.right;
				continue;
			} else {
				break;
			}
		}
		return cur;
	}
}
