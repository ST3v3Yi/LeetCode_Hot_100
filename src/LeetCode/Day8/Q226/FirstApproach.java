package LeetCode.Day8.Q226;

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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root) {
        if (root == null)
            return;
        invert(root.left);
        invert(root.right);
        TreeNode tmp = new TreeNode();
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
