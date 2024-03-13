package LeetCode.Day14.Q153;

import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {3,4,5,1,2};
        /**
         * 1,2,3,4,5
         * 5,1,2,3,4
         * 4,5,1,2,3
         * 3,4,5,1,2
         * 2,3,4,5,1
         * */
        System.out.println(findMin(nums));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
