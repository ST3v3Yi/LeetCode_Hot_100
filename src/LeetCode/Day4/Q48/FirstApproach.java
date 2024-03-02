package LeetCode.Day4.Q48;

import org.junit.Test;

import java.util.Arrays;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    private void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] a = new int[row][col];
        int n = row - 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[j][n-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                matrix[i][j] = a[i][j];
            }
        }
    }
}
