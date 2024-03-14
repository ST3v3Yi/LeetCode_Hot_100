package LeetCode.Day15.Q84;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] heights = {0};
        System.out.println(largestRectangleArea(heights));
    }
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0; // 处理边界情况
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
