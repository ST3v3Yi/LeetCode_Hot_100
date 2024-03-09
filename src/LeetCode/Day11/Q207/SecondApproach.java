package LeetCode.Day11.Q207;

import org.junit.Test;

import java.util.*;

public class SecondApproach {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();    // 邻接表
        int[] indegree = new int[numCourses];   // 入度
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            adjList.get(prerequisite).add(course);
            indegree[course]++;
        }
        int cnt = 0;
        // 使用队列进行拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            cnt++;
            // 更新入度
            for (int i : adjList.get(course)) {
                if (--indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return cnt == numCourses;
    }
    @Test
    public void justTest() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites)); // Output: true
    }
}
