package LeetCode.Day13.Q131;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        String s = "aab";
        System.out.println(partition(s));
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        for (int end = 0; end < n; end++) {
            for (int start = 0; start < n; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }
        partitionHelper(s, 0, dp, curr, ans);
        return ans;
    }
    public void partitionHelper(String s, int start, boolean[][] dp, List<String> curr, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                curr.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, dp, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
