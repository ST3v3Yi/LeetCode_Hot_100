package LeetCode.Day14.Q4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        List<Integer> nums = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i]);
                i++;
            } else {
                nums.add(nums2[j]);
                j++;
            }
        }
        while (j < nums2.length) {
            nums.add(nums2[j++]);
        }
        while (i < nums1.length) {
            nums.add(nums1[i++]);
        }
        if (n % 2 == 0) {
            return (double)(nums.get(n / 2) + nums.get(n / 2 - 1)) / 2;
        }
        return (double)nums.get(n / 2);
    }
}
