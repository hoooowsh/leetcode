package medium;

import java.util.ArrayList;
import java.util.List;

import easy.BalancedBinaryTree_110.TreeNode;

public class UniqueBST2_95 {
	public static void main(String args[]) {
		generateTrees(3);

	}

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> result = new ArrayList<>();
		// this is to store dp result, dp[1] is trees that can be built by 1 treenode
		ArrayList<ArrayList<TreeNode>> dp = new ArrayList<>();
		if (n == 0) {
			return result;
		}
		// for dp[0]
		TreeNode node0 = null;
		ArrayList<TreeNode> arr0 = new ArrayList<>();
		arr0.add(node0);
		dp.add(arr0);
		// for dp[1]
		TreeNode node1 = new TreeNode(1);
		ArrayList<TreeNode> arr1 = new ArrayList<>();
		arr1.add(node1);
		dp.add(arr1);
		if (n == 1) {
			return arr1;
		}
		// for dp[2]
		TreeNode node2_1 = new TreeNode(1);
		TreeNode node2_2 = new TreeNode(2);
		node2_1.right = node2_2;
		ArrayList<TreeNode> arr2 = new ArrayList<>();
		arr2.add(node2_1);
		TreeNode node2_3 = new TreeNode(1);
		TreeNode node2_4 = new TreeNode(2);
		node2_4.left = node2_3;
		arr2.add(node2_4);
		dp.add(arr2);
		if (n == 2) {
			return arr2;
		}
		// after dp[2], loop through to make every node as root
		for (int i = 3; i < n + 1; i++) {
			ArrayList<TreeNode> temparr = new ArrayList<>();
			// loop through every possible left subtree num and right subtree num
			for (int j = 0; j < i; j++) {
				int leftsubtree_len = dp.get(j).size();
				int rightsubtree_len = dp.get(i - j - 1).size();
				// loop through to get every possible trees
				for (int k = 0; k < leftsubtree_len; k++) {
					for (int l = 0; l < rightsubtree_len; l++) {
						TreeNode clone_l = copy(dp.get(j).get(k));
						TreeNode clone_r = copy(dp.get(i - j - 1).get(l));
						TreeNode curnode = new TreeNode(i);
						curnode.left = clone_l;
						curnode.right = clone_r;
						temparr.add(curnode);
					}
				}
			}
			dp.add(temparr);
		}
		return dp.get(dp.size() - 1);
	}

	// helper method to clone a tree
	public static TreeNode copy(TreeNode cur) {
		if (cur == null) {
			return null;
		}
		TreeNode copynode = new TreeNode(cur.val);
		copynode.left = copy(cur.left);
		copynode.right = copy(cur.right);
		return copynode;
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
