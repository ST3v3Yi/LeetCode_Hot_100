package LeetCode.Day12.Q17;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), map, digits, 0);
        return ans;
    }
    public void backtrack(List<String> ans, StringBuilder tmp, Map<Character, Character[]> map, String digits, int start) {
        if (tmp.length() == digits.length()) {
            ans.add(tmp.toString());
            return;
        }
        Character[] chars = map.get(digits.charAt(start));
        for (Character ch : chars) {
            tmp.append(ch);
            backtrack(ans, tmp, map, digits, start + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
