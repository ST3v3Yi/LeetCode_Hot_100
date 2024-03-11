package LeetCode.Day12.Q79;

import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCFCED";
        System.out.println(exist(board, word));
    }
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 ||
                i >= board.length ||
                j < 0 ||
                j >= board[0].length ||
                board[i][j] != word.charAt(idx) ||
                visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (backtrack(board, word, idx + 1, i - 1, j, visited) ||
                backtrack(board, word, idx + 1, i + 1, j, visited) ||
                backtrack(board, word, idx + 1, i, j - 1, visited) ||
                backtrack(board, word, idx + 1, i, j + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
