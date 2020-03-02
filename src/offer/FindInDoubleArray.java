package offer;

/**
 * @Author: JH
 * 在二维数组中查找
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * @Date: 2019/3/28 20:33
 */
public class FindInDoubleArray {

    public static boolean find(int target, int [][] array) {
        if(array == null||array.length==0) return false;
        int rowIdx = 0,colIdx = array[0].length-1;
        while(rowIdx<array.length&&colIdx>=0){
            if(array[rowIdx][colIdx] == target)
                return true;
            else if(target>array[rowIdx][colIdx])
                rowIdx++;
            else if(target<array[rowIdx][colIdx])
                colIdx--;
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array = new int[4][3];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 3;

        array[1][0] = 4;
        array[1][1] = 5;
        array[1][2] = 6;

        array[2][0] = 7;
        array[2][1] = 8;
        array[2][2] = 9;
        array[3][0] = 10;
        array[3][1] = 11;
        array[3][2] = 12;
        System.out.println(check(13,array));
    }

    public static boolean check(int target , int [][] array) {
        if(array == null  || array.length == 0)return false;
        int rowIndex = 0;
        int colIndex = array[0].length-1;
        while (rowIndex < array.length && colIndex >=0) {
            if(target == array[rowIndex][colIndex])return true;
            else if(target > array[rowIndex][colIndex]) {
                rowIndex ++;
            }else {
                colIndex -- ;
            }
        }
        return false;
    }


}
