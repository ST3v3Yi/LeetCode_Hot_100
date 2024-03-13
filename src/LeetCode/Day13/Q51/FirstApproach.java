package LeetCode.Day13.Q51;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        NQueensHelper(ans, board, n, 0);
        return ans;
    }
    public void NQueensHelper(List<List<String>> ans, char[][] board, int n, int row) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp.add(new String(board[i]));
            }
            ans.add(tmp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                NQueensHelper(ans, board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }
    public boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上对角线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 检查右上对角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
