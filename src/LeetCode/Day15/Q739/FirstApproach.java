package LeetCode.Day15.Q739;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class FirstApproach {
    @Test
    public void justTest() {
        int[] temperature = {30,40,50,60};
        System.out.println(Arrays.toString(dailyTemperatures(temperature)));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // 使用栈存储温度数组的索引
        for (int i = 0; i < temperatures.length; i++) {
            // 如果栈非空且当前温度比栈顶索引对应的温度高
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // 弹出栈顶索引
                ans[prevIndex] = i - prevIndex; // 更新栈顶索引对应的结果
            }
            stack.push(i); // 当前温度的索引入栈
        }
        return ans;
    }
}
