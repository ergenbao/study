package offer;

/**
 * @Author JH
 * 快排
 **/
public class QuickSort {


    private static void QuickSort(int[] arr, int left, int right) {
        if(left>=right) {
            return;
        }
        int i = left;
        int j = right;
        int key = arr[left];
        while (i < j) {
            while (i<j && arr[j]>=key) {
                j--;
            }
            while ((i<j && arr[i]<=key)) {
                i++;
            }
            if(i <j) {
                swap(arr,i,j);
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        QuickSort(arr,left,i-1);
        QuickSort(arr,i+1,right);


    }
    public static void swap(int [] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static int[] getMinK(int[] arr,int k) {
        QuickSort(arr,0,arr.length-1);
        int [] arrK = new int[k];
        System.arraycopy(arr,0,arrK,0,k);
        return arrK;
    }


    public static void main(String[] args) {
        int[] arr = {1,8,7,6,4,9,5,3};
        int[] arrK = getMinK(arr,5);
        for(int i =0 ;i<arrK.length;i++) {
            System.out.println(arrK[i]);
        }
    }



}
