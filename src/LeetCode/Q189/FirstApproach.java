package LeetCode.Q189;

import org.junit.Test;

import java.util.Arrays;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
    private void rotate(int[] nums, int k){
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[(i+k)%n] = nums[i];
        }
//        System.arraycopy(a, 0, nums, 0, n);
        for (int i = 0; i < n; i++){
            nums[i] = a[i];
        }
    }
}
