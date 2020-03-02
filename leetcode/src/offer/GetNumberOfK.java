package offer;

import java.util.Arrays;

/**
 * @Author JH
 * 统计一个数字在排序数组中出现的次数
 **/
public class GetNumberOfK {


    public static int getNumberOfK(int[] array,int k) {
         int num =0;

        if(array == null || array.length == 0) {
            return 0;
        }
        if(array.length == 1) {
            if(k == array[0]) {
                return 1;
            }else {
                return 0;
            }
        }
        int mid = array.length/2;
        if(k < array[mid]) {
            num += getNumberOfK(Arrays.copyOfRange(array,0,mid),k);
        }else if(k > array[mid]) {
            num += getNumberOfK(Arrays.copyOfRange(array,mid,array.length),k);
        }else {
           for(int i = k;i<array.length;i++) {
               if(k == array[i]) {
                   num++;
               }else {
                   break;
               }
           }
           for (int i = k -1 ;i>0;i--) {
               if(k == array[i]) {
                   num++;
               }else {
                   break;
               }
           }
        }
        return num;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,5,5,5,6,7,8,9};
            System.out.println(getNumberOfK(arr,5));

    }

}
