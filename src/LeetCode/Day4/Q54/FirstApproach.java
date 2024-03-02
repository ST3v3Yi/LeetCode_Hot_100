package LeetCode.Day4.Q54;

import org.junit.Test;
import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
//    private List<Integer> spiralOrder(int[][] matrix) {
//        List<Integer> list = new ArrayList<>();
//        int i = 0, j = 1;   // 初始位置
//        int row = matrix.length;  // row
//        int col = matrix[0].length; // col
//        int Nodes = row * col;  // 节点数，用来判断循环结束与否
//        list.add(matrix[0][0]);
//        matrix[0][0] = 101;
//        while (Nodes > 0) {
//            if (j < col - 1 && matrix[i][j+1] != 101) {
//                for (int k = j; k < col; k++) {
//                    if ((k == col - 1 && matrix[i][k] != 101) || matrix[i][k+1] != 101) {
//                        list.add(matrix[i][k]);
//                        matrix[i][k] = 101;
//                        j = k;
//                        Nodes--;
//                    }
//                }
//            } else if (i < row - 1 && matrix[i+1][j] != 101) {
//                for (int k = i; k < row; k++) {
//                    if ((k == row - 1 && matrix[k][j] != 101) || matrix[k+1][j] != 101) {
//                        list.add(matrix[k][j]);
//                        matrix[k][j] = 101;
//                        i = k;
//                        Nodes--;
//                    }
//                }
//            } else if (j > 0 && matrix[i][j-1] != 101) {
//                for (int k = j; k >= 0; k--) {
//                    if ((k == 0 && matrix[i][0] != 101) || matrix[i][k-1] != 101) {
//                        list.add(matrix[i][k]);
//                        matrix[i][k] = 101;
//                        j = k;
//                        Nodes--;
//                    }
//                }
//            } else if (i > 0 && matrix[i-1][j] != 101){
//                for (int k = i; k >= 0; k--) {
//                    if ((k == 0 && matrix[0][j] != 101) || matrix[k-1][j] != 101) {
//                        list.add(matrix[k][j]);
//                        matrix[k][j] = 101;
//                        i = k;
//                        Nodes--;
//                    }
//                }
//            }
//            Nodes--;
//        }
//        return list;
//    }
    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;   // 初始位置应该是 (0, 0)
        int row = matrix.length;  // 行数
        int col = matrix[0].length; // 列数
        int Nodes = row * col;  // 节点数，用来判断循环结束与否
        list.add(matrix[0][0]);
        matrix[0][0] = 101; // 标记已经访问过的节点为 101
        while (Nodes > 1) { // 循环终止条件改为判断是否还有节点未访问
            if (j < col - 1 && matrix[i][j+1] != 101) { // 向右
                while (j < col - 1 && matrix[i][j+1] != 101) {
                    j++;
                    list.add(matrix[i][j]);
                    matrix[i][j] = 101;
                    Nodes--;
                }
            }
            if (i < row - 1 && matrix[i+1][j] != 101) { // 向下
                while (i < row - 1 && matrix[i+1][j] != 101) {
                    i++;
                    list.add(matrix[i][j]);
                    matrix[i][j] = 101;
                    Nodes--;
                }
            }
            if (j > 0 && matrix[i][j-1] != 101) { // 向左
                while (j > 0 && matrix[i][j-1] != 101) {
                    j--;
                    list.add(matrix[i][j]);
                    matrix[i][j] = 101;
                    Nodes--;
                }
            }
            if (i > 0 && matrix[i-1][j] != 101) { // 向上
                while (i > 0 && matrix[i-1][j] != 101) {
                    i--;
                    list.add(matrix[i][j]);
                    matrix[i][j] = 101;
                    Nodes--;
                }
            }
        }
        return list;
    }

}
