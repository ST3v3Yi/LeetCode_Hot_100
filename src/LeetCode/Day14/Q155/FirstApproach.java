package LeetCode.Day14.Q155;

import java.util.ArrayList;
import java.util.List;

public class FirstApproach {
    class MinStack {
        int i;  // 指向栈顶位置
        List<Integer> nums; // 存储元素的空间
        int minPoint;   // 指向最小元素的下标

        public MinStack() {
            nums = new ArrayList<>();
        }

        public void push(int val) {
            if (nums.size() == 0) {
                nums.add(val);
                i = 0;
                minPoint = 0;
            } else {
                nums.add(val);
                i++;
                minPoint = (val < nums.get(minPoint)) ? i : minPoint;
            }
        }

        public void pop() {
            if (nums.size() != 0) {
                nums.remove(nums.size() - 1);
                i--;
                if (i < minPoint) {
                    // 如果弹出的元素正好是最小元素，则重新找到最小元素的索引位置
                    minPoint = 0;
                    for (int j = 1; j < nums.size(); j++) {
                        if (nums.get(j) < nums.get(minPoint)) {
                            minPoint = j;
                        }
                    }
                }
            }
        }

        public int top() {
            if (nums.size() == 0) {
                return 0;
            }
            return nums.get(i);
        }

        public int getMin() {
            if (nums.size() == 0) {
                return 0;
            }
            return nums.get(minPoint);
        }
    }
}
