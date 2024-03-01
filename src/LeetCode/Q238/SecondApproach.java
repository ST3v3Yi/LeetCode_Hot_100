package LeetCode.Q238;

import org.junit.Test;

import java.util.Arrays;

public class SecondApproach {
    @Test
    public void justTest() {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    /*
    * 时间换空间
    * 设置两个数组：leftProduct[]和rightProduct[]
    * 分别记录位置i的左边和右边的乘积
    * */
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int n = nums.length;
        int[] leftProduct = new int[n];
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        int[] rightProduct = new int[n];
        rightProduct[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }
        return ans;
    }
}
