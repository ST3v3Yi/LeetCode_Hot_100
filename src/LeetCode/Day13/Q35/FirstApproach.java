package LeetCode.Day13.Q35;

import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // 目标值找到，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
            }
        }
        return right + 1;
    }
}
