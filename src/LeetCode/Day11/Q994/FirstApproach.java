package LeetCode.Day11.Q994;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int time = 0;
        int row = grid.length;
        int col = grid[0].length;
        int freshOrange = 0;
        Queue<Integer> RottedOranges = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    RottedOranges.add(i * col + j); // 存储腐烂橘子的位置
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }
        while (!RottedOranges.isEmpty() && freshOrange > 0) {
            int size = RottedOranges.size();
            for (int i = 0; i < size; i++) {
                int num = RottedOranges.poll();
                int r = num / col;   // row
                int c = num % col;   // col
                if (r - 1 >=0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    RottedOranges.add((r-1)*col + c);
                    freshOrange--;
                }
                if (r + 1 <= row - 1 && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    RottedOranges.add((r+1)*col + c);
                    freshOrange--;
                }
                if (c - 1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    RottedOranges.add(r*col + c - 1);
                    freshOrange--;
                }
                if (c + 1 <= col - 1 && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    RottedOranges.add(r*col + c + 1);
                    freshOrange--;
                }
            }
            if (!RottedOranges.isEmpty())
                time++;
        }
        return freshOrange == 0 ? time : -1;
    }
}
