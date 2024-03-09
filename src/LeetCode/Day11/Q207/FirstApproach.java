package LeetCode.Day11.Q207;

public class FirstApproach {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int maxNum = 0;
        int maxIndex = 0;
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i].length > maxNum) {
                maxNum = prerequisites[i].length;
                maxIndex = i;
            }
        }
        if (numCourses < maxNum) {
            return false;
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (i == maxIndex)
                continue;
            if (!isSubarray(prerequisites[maxIndex], prerequisites[i])) {
                return false;
            }
        }
        return true;
    }
    public boolean isSubarray(int[] num, int[] subArray) {
        int m = num.length;
        int n = subArray.length;
        int i = 0;  // 主数组指针
        int j = 0;  // 子数组指针
        while (i < m && j < n) {
            if (num[i] == subArray[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == n;
    }
}
