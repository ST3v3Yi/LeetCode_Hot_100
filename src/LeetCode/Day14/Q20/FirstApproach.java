package LeetCode.Day14.Q20;

import org.junit.Test;

import java.util.Stack;

public class FirstApproach {
    @Test
    public void justTest() {
        String s = "()]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int n = s.length(); // s的长度
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                // 如果当前右括号与栈顶的左括号不匹配，返回 false
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}