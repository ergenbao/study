package offer;

/**
 * @Author: JH
 * @Date: 2019/3/30 12:22
 * 旋转数组的最小数字
 */
public class MinNumInRotateArray {

//    public  static int minNumberInRotateArray(int [] array) {
//        if(array == null || array.length ==0) return 0;
//        int low = 0 ; int high = array.length - 1;
//        while(low < high){
//            int mid = low + (high - low) / 2;
//            if(array[mid] > array[high]){
//                low = mid + 1;
//            }else if(array[mid] == array[high]){
//                high = high - 1;
//            }else{
//                high = mid;
//            }
//        }
//        return array[low];
//    }

    public static void main(String[] args) {
//        int[] array = null;
//        int[] array = {};
//        int[] array = { 1 };
//        int[] array = { 1, 2, 3, 4, 5, 6 };
        int[] array = { 2, 2, 2, 2, 1, 2 };
//        int[] array = { 2, 1, 2, 2, 2, 2 };
//        int[] array = { 6, 6, 8, 9, 10, 1, 2, 2, 3, 3, 4, 5, 6 };
//        System.out.println(minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int low = 0 ,high = array.length - 1  ;
        while (low < high) {
            int mid = low + (high - low)/2;
            if(array[mid] > array[high]) {
                low= mid + 1;
            }else if(array[mid] == array[high]) {
                high = high -1;
            }else {
                high = mid;
            }
        }
        return array[low];
    }


}
