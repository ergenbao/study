package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JH
 * @Date: 2019/4/22 17:14
 * 基数排序
 */
public class RadixSort {

    public static void radixSort(int[] arr) {
        for (int i = 0 ; i <arr.length-1;i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr,i,i+1);
            }
        }
        int max_num = arr[arr.length -1];
        int count = 0;
        while (max_num /10> 0 ){
            max_num /= 10;
            count++;
        }
        List<List<Integer>> result=  new ArrayList<>();
        for (int i = 0 ; i<10;i++) {
            result.add(new ArrayList<>());
        }
        for (int i = 0;i<=count;i++) {
            for (int num : arr){
                int a = (int)(num % Math.pow(10,i+1)/Math.pow(10,i));
                result.get(a).add(num);
            }
            int index = 0;
            for (int j =0;j<10;j++) {
                while (result.get(j).size()>0) {
                    arr[index++] = result.get(j).remove(0);
                }
            }
        }

    }

    public static void swap(int[] arr ,int a , int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = {87,45,78,32,17,65,53,9,122,133};
        radixSort(a);
        System.out.println(Arrays.toString(a));
//        System.out.println((int)(45 % Math.pow(10,1)));
    }

}
