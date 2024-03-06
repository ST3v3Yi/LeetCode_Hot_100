package LeetCode.Day8.Q101;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

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
    public boolean isSymmetric(TreeNode root) {
        TreeNode copy = copyTree(root);
        invert(copy);
        return isSameTree(root, copy);
    }

    // 判断两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树的根节点都为空，则认为它们相等
        if (p == null && q == null)
            return true;
        // 如果两个树中有且仅有一个根节点为空，则认为它们不相等
        if (p == null || q == null)
            return false;
        // 如果两个树的根节点的值不相等，则认为它们不相等
        if (p.val != q.val)
            return false;
        // 递归地比较两棵树的左子树和右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 复制一棵树
    public TreeNode copyTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode copyRoot = new TreeNode(root.val);
        copyRoot.left = copyTree(root.left);
        copyRoot.right = copyTree(root.right);
        return copyRoot;
    }

    // 翻转树的结构
    public void invert(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);
    }
}
