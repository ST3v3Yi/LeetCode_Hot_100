package LeetCode.Day8.Q543;

public class FirstApproach {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        maxDepth(root);
        return diameter;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            diameter = Math.max(diameter, leftMaxDepth + rightMaxDepth);
            return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        }
    }
}
