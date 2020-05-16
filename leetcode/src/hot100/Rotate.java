package hot100;

/**
 * @ClassName Rotate
 *  将图像顺时针旋转90°
 * @Description 旋转图像 先i、j调换  再每一行关于对称轴翻转
 * @Author JH
 * @Date 2019/9/4 16:24
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}
