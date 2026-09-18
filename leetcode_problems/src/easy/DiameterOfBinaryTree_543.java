package easy;

import java.util.ArrayList;

public class DiameterOfBinaryTree_543 {
    public static void main(String[] args) {
        // TreeNode root = new TreeNode();
        // root.val = 1;
        // root.right = new TreeNode();
        // root.right.val = 2;
        // root.right.left = new TreeNode();
        // root.right.right = new TreeNode();
        // root.right.left.val = 3;
        // root.right.right.val = 4;
        // root.right.left.left = new TreeNode();
        // root.right.left.left.val = 5;
        // diameterOfBinaryTree(root);

        TreeNode root = new TreeNode();
        root.val = 1;
        root.right = new TreeNode();
        root.right.val = 3;
        root.left = new TreeNode();
        root.left.val = 2;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 5;
        diameterOfBinaryTree(root);
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxArr = new int[1];
        getMax2(root, maxArr);
        return maxArr[0];
    }

    public static int getMax2(TreeNode cur, int[] arr) {
        if (cur == null) {
            return 0;
        }
        int left = getMax2(cur.left, arr);
        int right = getMax2(cur.right, arr);
        if (left + right > arr[0]) {
            arr[0] = left + right;
        }
        return 1 + Math.max(left, right);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        getMax(root, list);
        return list.get(0);
    }

    public static int getMax(TreeNode cur, ArrayList<Integer> max) {
        if (cur == null) {
            return 0;
        }
        if (cur.left == null && cur.right == null) {
            return 1;
        }
        int left = getMax(cur.left, max);
        int right = getMax(cur.right, max);
        int temp = left + right;
        if (temp > max.get(0)) {
            max.set(0, temp);
        }
        return Math.max(left, right) + 1;
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
