package sort;



import java.util.Arrays;

/**
 * @Author: JH
 * @Date: 2019/4/22 15:16
 * 大顶堆排序
 */
public class BigHeapSort {

//    public void heapSort(int[] arr) {
//        //初始化堆
//        buildHeap(arr);
//        for (int i = arr.length-1 ;i >=1;i--) {
//            swap(arr,0,i);
//            adjustHeap(arr,0,i);
//        }
//    }
//
//    public void buildHeap(int[] arr) {
//        for (int i = arr.length/2 -1;i>=0;i--) {
//            adjustHeap(arr,i,arr.length);
//        }
//    }
//    public void adjustHeap(int[] arr,int k ,int length) {
//        int temp = arr[k];
//        for (int i = 2*k +1;i<=length -1;i = 2*i+1) {
//            if (i+1 <length && arr[i] < arr[i+1]) {
//                i++;
//            }
//            if (temp >arr[i]) {
//                break;
//            }else {
//                arr[k] = arr[i];
//                k = i;
//            }
//        }
//        arr[k] = temp;
//    }
//
    public void swap(int[] arr ,int a , int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void heapSort(int[] nums) {
        //初始化堆
        buildHeap(nums,0,nums.length);
        for (int i = nums.length -1;i>0;i--) {
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
    }

    public void buildHeap(int[] nums,int k,int length) {

        for (int i = length/2 -1;i >=0 ; i--) {
            adjustHeap(nums,i,length);
        }
    }
    public void adjustHeap(int[] nums,int k,int length) {
        int key = nums[k];
        for (int i = k;i<length;i = 2*i +1) {
            if (i+1 <length && nums[i] <nums[i+1]) {
                    i++;
            }
            if (key < nums[i]) {
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = key;
    }




    public void test() {
//        int[] a = {87,45,78,32,17,65,53,9,122,133};
//        heapSort(a);
//        System.out.println(Arrays.toString(a));
    }

}
