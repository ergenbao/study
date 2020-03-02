package offer;

/**
 * @Author JH
 * 求连续子数组的最大和
 **/
public class FindGreatestSumOfSubArray {




    public static void main(String[] args) {
        int[] arr = {-1,10,26,-16,20,25};
        System.out.println(sulotion(arr));
    }

    public static int sulotion(int[] arr) {
        if(arr == null ||arr.length == 0) {
            return 0;
        }
        int cur = arr[0];
        int great = arr[0];
        for(int i = 1;i<arr.length;i++) {
            if(cur < 0) {
                cur = arr[i];
            }else {
                cur+=arr[i];
            }
            if(cur>great) {
                great = cur;
            }
        }

        return great;
    }



}
