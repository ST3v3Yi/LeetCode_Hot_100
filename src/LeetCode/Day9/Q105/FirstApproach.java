package LeetCode.Day9.Q105;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 利用递归函数构造二叉树
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 递归终止条件：如果前序遍历序列为空，则返回null
        if (preStart > preEnd) {
            return null;
        }
        // 根据前序遍历序列确定根节点的值
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历序列中找到根节点的位置
        int rootIndex = inStart;
        while (inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        // 根据根节点在中序遍历序列中的位置，将中序遍历序列分成左子树和右子树两部分
        int leftSize = rootIndex - inStart;
        // 递归构造左子树
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        // 递归构造右子树
        root.right = buildTreeHelper(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
