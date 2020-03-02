package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: JH
 * @Date: 2019/4/22 16:20
 * 归并排序
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0 ) {
            return;
        }

        sort(arr,0,arr.length -1);
    }

    public void sort(int [] arr ,int left,int right) {
        if(left < right) {
            int mid = (left +right) / 2;
            sort(arr,left,mid);
            sort(arr,mid +1,right);
            int[] temp = new int[arr.length];
            merge(arr,left,mid,right,temp);
        }
    }

    public void merge(int [] arr ,int left,int mid,int right,int[] temp) {
        int i = left,j = mid+1,t = 0;
        while (i <= mid && j <=right) {
            if(arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        System.arraycopy(temp,0,arr,left,t);
    }

   @Test
    public void test() {
        int[] a = {87,45,78,32,17,65,53,9,122,133};
       mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

}
