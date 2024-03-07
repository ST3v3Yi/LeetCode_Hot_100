package LeetCode.Day9.Q98;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int prev = 0;
        for (int curr = 1; curr < res.size(); curr++) {
            if (res.get(prev) >= res.get(curr)) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
