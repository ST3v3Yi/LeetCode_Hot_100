package LeetCode.Day3.Q41.Q56;
import org.junit.Test;

import java.util.*;

public class SecondApproach {
    @Test
    public void justTest() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private int[][] merge(int[][] intervals) {
        // 按照intervals中各元素的start位置的大小进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 使用列表存储合并后的区间
        List<int[]> merged = new ArrayList<>();
        // 遍历所有区间
        for (int[] interval : intervals) {
            // 如果合并后的区间列表为空，或当前区间的起始位置大于列表中最后一个区间的终止位置，则直接将当前区间加入列表
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // 否则，更新列表中最后一个区间的终止位置为当前区间的终止位置
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        // 将列表转换为数组并返回
        return merged.toArray(new int[merged.size()][]);
    }
}
