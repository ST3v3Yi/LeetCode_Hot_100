package LeetCode.Day4.Q48;

import org.junit.Test;

import java.util.Arrays;

public class SecondApproach {
    @Test
    public void justTest() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    private void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row - 1;
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i][j];
                matrix[n-i][j] = tmp;
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
