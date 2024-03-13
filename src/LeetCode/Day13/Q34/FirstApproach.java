package LeetCode.Day13.Q34;

import org.junit.Test;

import java.util.Arrays;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] nums = {};
        int target = 0;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && target == nums[0]) {
            return new int[]{0, 0};
        }
        int[] part = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                part[0] = mid;
                part[1] = mid;
                while (left <= mid) {
                    if (nums[left] == target) {
                        part[0] = left;
                        break;
                    }
                    left++;
                }
                while (right >= mid) {
                    if (nums[right] == target) {
                        part[1] = right;
                        break;
                    }
                    right--;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return part;
    }
}
