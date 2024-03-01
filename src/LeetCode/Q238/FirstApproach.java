package LeetCode.Q238;

import org.junit.Test;

import java.util.Arrays;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    /*除自身以外数组的乘积
    *  最简单的方法不就是二重循环得到结果
    * */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int sum = 1;
            for (int j = 0; j < nums.length; j++){
                if (i == j)
                    continue;
                sum *= nums[j];
            }
            ans[i] = sum;
        }
        return ans;
    }
//    public int[] productExceptSelf(int[] nums) {
//        int[] ans = new int[nums.length];
//        return ans;
//    }
}
