package sort;

/**
 * @Author: JH
 * @Date: 2019/4/6 19:49
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        for(int i = 0 ;i<arr.length;i++) {
            for (int j = 0;j<arr.length-1-i;j++) {
                if(arr[j] < arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }

    }
    public static void swap(int[] arr ,int index1,int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,8,7,4,1,6};
        bubbleSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]);
        }
    }

}
