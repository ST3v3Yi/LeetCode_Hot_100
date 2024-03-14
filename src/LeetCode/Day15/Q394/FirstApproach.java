package LeetCode.Day15.Q394;

import org.junit.Test;

import java.util.Deque;
import java.util.Stack;

public class FirstApproach {
    @Test
    public void justTest() {
        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder decodedString = new StringBuilder();
        int n = s.length();
        for (char ch : s.toCharArray()) {
            if (ch <= '9' && ch >= '0') {
                stack.push(ch);
            } else if ((ch >= 'a' && ch <= 'z') || ch == '[') {
                stack.push(ch);
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder();
                // 弹出字符直到找到 '['
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.insert(0, stack.pop());
                }
                stack.pop(); // 弹出 '['

                StringBuilder countString = new StringBuilder();
                // 弹出数字以形成重复次数
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    countString.insert(0, stack.pop());
                }
                int count = Integer.parseInt(countString.toString());

                // 重复子串 count 次并将其推回栈中
                String repeatedSubstring = temp.toString().repeat(count);
                for (char c : repeatedSubstring.toCharArray()) {
                    stack.push(c);
                }
            }
        }
        // 弹出栈中剩余的字符并将它们附加到 decodedString 中
        while (!stack.isEmpty()) {
            decodedString.insert(0, stack.pop());
        }
        return decodedString.toString();
    }
}
