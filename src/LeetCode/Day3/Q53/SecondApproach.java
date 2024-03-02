package LeetCode.Day3.Q41.Q53;

import org.junit.Test;

public class SecondApproach {
    @Test
    public void justTest() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
    /*
     * 动态规划
     * */
    private int maxSubArray(int[] nums){
        int pre = 0, maxAns = nums[0];
        for (int x : nums){
            pre = Math.max(pre + x, x);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }
}
