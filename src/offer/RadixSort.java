package offer;

import java.util.ArrayList;

/**
 * @Author JH
 * 基数排序
 **/
public class RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //0-9十个桶
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0 ;i <10;i++) {
            ArrayList<Integer> bucket = new ArrayList<>();
            buckets.add(bucket);
        }
        int max = arr[0];
        for (int i : arr) {
            if (i > max){
                max = i;
            }
        }

        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }

        for (int i = 0 ;i < time;i++) {

            for (int j = 0;j<arr.length;j++) {
                int key = arr[j] % (int)Math.pow(10,i+1) / (int)Math.pow(10,i);
                buckets.get(key).add(arr[j]);
            }

            int point = 0;
            for (int k = 0 ;k < 10;k++) {
                ArrayList<Integer> bucket = buckets.get(k);
                while (!bucket.isEmpty()) {
                    arr[point++] = bucket.remove(0);
                }
            }
        }


    }

    public static void main(String[] args) {
        int[]  arr = {2,6,88,25,123,654,88,66,1101};
        radixSort(arr);
        for (int i : arr) {
            System.out.print(i+"        ");
        }

    }

}
