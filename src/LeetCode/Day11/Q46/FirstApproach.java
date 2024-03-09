package LeetCode.Day11.Q46;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backtrack(res, tmp, nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) {
                continue;
            }
            tmp.add(nums[i]);
            backtrack(res, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
    @Test
    public void justTest() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
