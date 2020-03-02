package sort;

/**
 * @Author: JH
 * @Date: 2019/4/6 20:24
 * 快速排序
 */
public class QuickSort{

    public  static void quickSort(int[] arr,int start,int end) {
        if(start >= end) {
            return;
        }
        int l =start,  r = end;
        int key = arr[l];
        while(l < r) {
            while(l < r && arr[r] >= key) {
                r--;
            }
            arr[l] = arr[r];
            while(l <r && arr[l] <= key) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = key;
        quickSort(arr,start,l-1);
        quickSort(arr,l+1,end);

    }




    public static void main(String[] args) {
        int[] arr = {2,3,4,2,1,5,58,9,9,0,-1};
        quickSort(arr,0,arr.length -1);
        StringBuilder  sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }

}
