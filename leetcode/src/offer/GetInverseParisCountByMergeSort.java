package offer;

/**
 * @Author JH
 * 数组中的逆序对：数组中任意的两个数字，如果前一个数字大于后一个数字，则这两个数字就构成了一个逆序对
 **/
public class GetInverseParisCountByMergeSort {

    private static int count = 0;
    public static int solution(int[] arr) {
        if(arr == null || arr.length ==0) {
            return 0;
        }
        sort(arr,0,arr.length-1);
        return count;

    }

    public static void sort(int[] arr,int left,int right) {
        int mid = (left+right) / 2 ;
        if(left < right) {
            sort(arr,left,mid);
            sort(arr,mid+1,right);
        }
        merge(arr,left,right,mid);
    }

    public static void merge(int[] arr,int left,int right,int mid) {

        int[] data = new int[right - left + 1];
        int p = 0;
        int s = left;
        int index = mid +1;
        while (left<=mid && index <=right) {
            if(arr[left] <= arr[index]) {
                data[p++] = arr[left++];
            }else {
                data[p++] = arr[index++];
                count = count+mid+1-left;
                count%=1000000007;
            }
        }

        while (left<=mid) {
            data[p++] = arr[left++];
        }
        while (index<=right) {
            data[p++] = arr[index++];
        }

        for(int i :data) {
            arr[s++] = i;
        }

    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,8,6,1};
         sort(arr,0,arr.length-1);
        for(int a : arr){
            System.out.println(a);
        }


    }

}
