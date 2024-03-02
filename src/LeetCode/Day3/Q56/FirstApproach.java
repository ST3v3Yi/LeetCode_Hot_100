package LeetCode.Day3.Q41.Q56;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    /*
    * 合并区间
    * 1.首先如何确定ans的长度
    * 2.合并
    * */
    private int[][] merge(int[][] intervals) {
        // 按照intervals中各元素的start位置的大小进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 确定ans的长度n
        int n = intervals.length;
        for (int i = 0; i < intervals.length-1; i++){
            if (intervals[i][1] >= intervals[i+1][0]){
                n--;
            }
        }
        // 获取ans
        int[][] ans = new int[n][2];
        /*
        * 双指针i和j
        * 其中，i始终指向ans对应的位置，方便插入数值
        * j始终对intervals中的数值进行判断并执行相应的跳过机制
        * */
        int j = 0;
        for (int i = 0; i < n; i++){
            ans[i][0] = intervals[j][0];
//            // 添加新的判断条件 intervals[j][1] < intervals[j+1][1]
//            if (j < intervals.length - 1 && intervals[j][1] >= intervals[j+1][0] && intervals[j][1] < intervals[j+1][1]){
//                j++;
//                ans[i][1] = intervals[j][1];
//            } else {
//                ans[i][1] = intervals[j][1];
//            }
//            j++;
            for (; j < intervals.length-1; j++){
                if (j < intervals.length-1 && intervals[j][1] >= intervals[j+1][0]){
                    if (intervals[j][1] < intervals[j+1][1]){
                        ans[i][1] = intervals[j+1][1];
                    } else {
                        ans[i][1] = intervals[j][1];
                    }
                } else {
                    ans[i][1] = intervals[j][1];
                    break;
                }
            }
            j++;
        }
        return ans;
    }
}
