package LeetCode.Day16.Q763;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstApproach {
    @Test
    public void justTest() {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return ans;
        }
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i});
            } else {
                map.get(c)[1] = i;
            }
        }
        int start = 0;
        int end = 0;
        // 根据第一个出现的字母来划分区间
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c)[1]);

            // 如果当前位置等于区间最大位置，表示已经到达区间末尾
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
