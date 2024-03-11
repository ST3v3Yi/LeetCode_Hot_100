package LeetCode.Day12.Q39;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondAppraoch {
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
    public void backtrack(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        backtrack(ans, tmp, candidates, target, idx + 1);
        if (target - candidates[idx] >= 0) {
            tmp.add(candidates[idx]);
            backtrack(ans, tmp, candidates, target - candidates[idx], idx);
            tmp.remove(tmp.size() - 1);
        }
    }
}
