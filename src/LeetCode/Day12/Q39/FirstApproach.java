package LeetCode.Day12.Q39;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> sortedTmp = new ArrayList<>(tmp);
            Collections.sort(sortedTmp);
            if (!ans.contains(sortedTmp)) {
                ans.add(sortedTmp);
                return;
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            if (sum + candidates[i] <= target) {
                backtrack(ans, tmp, candidates, target, sum + candidates[i]);
            }
            tmp.remove(tmp.size() - 1);
        }
    }
}
