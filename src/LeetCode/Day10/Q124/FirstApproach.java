package LeetCode.Day10.Q124;

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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }
    public int maxPathSumHelper(TreeNode root) {
        if (root == null)
            return 0;
        // 递归计算左子树和右子树的最大路径和
        int leftSum = Math.max(0, maxPathSumHelper(root.left));
        int rightSum = Math.max(0, maxPathSumHelper(root.right));

        // 计算当前节点的路径和
        int currSum = root.val + leftSum + rightSum;

        // 更新全局变量 maxSum
        maxSum = Math.max(maxSum, currSum);

        // 返回当前节点的最大路径和（只能选择左子树或右子树的一条路径）
        return root.val + Math.max(leftSum, rightSum);
    }
}
