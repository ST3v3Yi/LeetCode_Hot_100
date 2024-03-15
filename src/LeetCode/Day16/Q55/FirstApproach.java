package LeetCode.Day16.Q55;

import org.junit.Test;

import java.util.Map;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxDistance) {
                return false;
            }
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return maxDistance >= nums.length - 1;
    }
}
