package offer;

/**
 * @Author JH
 * 堆排序
 **/
public class HeapSort {

    public static void sort(int []arr){

        for (int i = arr.length/2-1;i>=0;i++) {
            adjustHeap(arr,i,arr.length);
        }

    }

    public static void adjustHeap(int[] arr,int i,int length) {

    }



    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,7,6,4,9,5,3};
        sort(arr);
        for(int i =0 ;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

}
