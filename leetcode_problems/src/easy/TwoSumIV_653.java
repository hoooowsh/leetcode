package easy;

import java.util.HashSet;

public class TwoSumIV_653 {
    public static void main(String[] args) {

    }

    public class TreeNode {
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

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(root.val);
        return helper(set, root.left, k) || helper(set, root.right, k);
    }

    public boolean helper(HashSet<Integer> set, TreeNode node, int target) {
        if (node == null) {
            return false;
        }
        if (set.contains(target - node.val)) {
            return true;
        } else {
            set.add(node.val);
            return helper(set, node.left, target) || helper(set, node.right, target);
        }
    }
}
