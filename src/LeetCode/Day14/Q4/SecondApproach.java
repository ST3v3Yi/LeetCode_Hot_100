package LeetCode.Day14.Q4;

import org.junit.Test;

public class SecondApproach {
    @Test
    public void justTest() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int halfLen = (m + n + 1) / 2;
        while (left < right) {
            int i = (right + left) / 2;
            int j = halfLen - i;
            if (i < m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                right = i;
            }
        }
        int i = left;
        int j = halfLen - left;
        int num1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int num1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int num2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int num2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            return Math.max(num1LeftMax, num2LeftMax);
        } else {
            return (double) (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2;
        }
    }
}
