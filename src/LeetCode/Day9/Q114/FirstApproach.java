package LeetCode.Day9.Q114;

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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        // 保存右子树
        TreeNode right = root.right;
        // 将左子树移到右子树的位置
        root.right = root.left;
        root.left = null;
        // 找到现在右子树的末端
        TreeNode curr = root;
        while (curr.right != null)
            curr = curr.right;
        // 将原始右子树连接到现在右子树的末端
        curr.right = right;
    }
}
