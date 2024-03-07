package LeetCode.Day9.Q199;

import java.util.*;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levelOrder = levelOrder(root);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < levelOrder.size(); i++) {
            res.add(levelOrder.get(i).get(levelOrder.get(i).size() - 1));
        }
        return res;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                levelNodes.add(treeNode.val);
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
            }
            res.add(levelNodes);
        }
        return res;
    }
}
