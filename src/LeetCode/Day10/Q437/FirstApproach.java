package LeetCode.Day10.Q437;

import org.junit.Test;

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
    int num = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 初始化，表示出现一次路径和为0的情况
        dfs(root, 0, targetSum, map);
        if (targetSum == 0)
            num--;
        return num;
    }
    public void dfs(TreeNode root, int currSum, int target, Map<Integer, Integer> map) {
        if (root == null)
            return;
        currSum += root.val;
        int cnt = map.getOrDefault(currSum - target, 0);
        num += cnt;
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        dfs(root.left, currSum, target, map);
        dfs(root.right, currSum, target, map);
        map.put(currSum, map.get(currSum) - 1);
    }
    @Test
    public void test() {
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.right = null;
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.right = null;
        root.left.left.left.left = new TreeNode(1000000000);

        System.out.println("Number of paths with sum 0: " + pathSum(root, 0)); // Output should be 0
    }
}
