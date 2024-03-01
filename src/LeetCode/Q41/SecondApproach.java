package LeetCode.Q41;

import org.junit.Test;

public class SecondApproach {
    @Test
    public void justTest() {
        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }
    private int firstMissingPositive(int[] nums) {
        // 首先排除掉所有小于等于0的数值，统统设为N+1
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }
}
