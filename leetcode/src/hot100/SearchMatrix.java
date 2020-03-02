package hot100;

/**
 * @ClassName SearchMatrix
 * @Description 搜索二维矩阵||
 * @Author JH
 * @Date 2019/10/17 16:33
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix,int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int posx = 0;
        int posy = col -1;
        //从右上角往左下角找
        while (posx < row && posy >= 0) {
            if(matrix[posx][posy] == target) {
                return true;
            }
            if(matrix[posx][posy] > target) {
                posy -- ;
            } else {
                posx ++;
            }
        }
        return false;
    }
}
