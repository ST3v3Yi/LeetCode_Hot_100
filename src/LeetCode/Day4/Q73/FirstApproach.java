package LeetCode.Day4.Q73;

import org.junit.Test;

import java.util.Arrays;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] matrix = {{0,1,2,0},{3,0,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    private void setZeroes(int[][] matrix) {
        int[][] a = new int[matrix.length][];
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flag = false;
        for (int i = 0; i < row; i++) {
            a[i] = Arrays.copyOf(matrix[i], col);
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
            flag = false;
        }
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                if (a[j][i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int j = 0; j < row; j++) {
                    a[j][i] = 0;
                }
            }
            flag = false;
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (a[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
