package offer;

/**
 * @Author JH
 * 归并排序
 **/
public class MergeSort {



    public static void main(String[] args) {
        int[] arr = {5,2,3,8,6,1};
        arr = sort(arr,0,arr.length-1);
        for(int a : arr){
            System.out.println(a);
        }


    }

    public static int[] sort(int[] arr,int left,int right) {
        if(arr == null || arr.length == 0 ) {
            return null;
        }
        if(left == right) {
            return new int[]{arr[left]};
        }

        int mid = (left + right) / 2;
        int[] l = sort(arr,left,mid);
        int[] r = sort(arr,mid+1,right);
        return merge(l,r);
    }
    public static int[] merge(int[] left,int[] right) {
        int[] arr = new int[left.length+right.length];
        int p = 0;
        int lp = 0;
        int rp = 0;

        while (lp < left.length && rp < right.length) {
            arr[p++] = left[lp] >= right[rp] ? right[rp++] : left[lp++];
        }
        while (lp < left.length) {
            arr[p++] = left[lp++];
        }
        while (rp <right.length) {
            arr[p++] = right[rp++];
        }
        return arr;

    }





}
