package LeetCode.Day4.Q240;

import org.junit.Test;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return flag;
    }
}
