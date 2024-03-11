package LeetCode.Day12.Q78;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int start) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(ans, tmp, nums, i+1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
