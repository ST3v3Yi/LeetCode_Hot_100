package LeetCode.Day3.Q41.Q53;
import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
    /*
    * 超过时间限制
    * */
    private int maxSubArray(int[] nums){
        int ans = -9999999;
        /*最简单的方法：双for循环*/
        for (int i = 0; i < nums.length; i++){
            int tmp = 0;
            for (int j = i; j < nums.length; j++){
                tmp += nums[j];
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
