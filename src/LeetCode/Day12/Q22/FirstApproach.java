package LeetCode.Day12.Q22;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder tmp, int n, int left, int right) {
        if (tmp.length() == n * 2) {
            ans.add(tmp.toString());
            return;
        }
        if (left < n) {
            tmp.append('(');
            backtrack(ans, tmp, n, left + 1, right);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (right < left) {
            tmp.append(')');
            backtrack(ans, tmp, n, left, right + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
