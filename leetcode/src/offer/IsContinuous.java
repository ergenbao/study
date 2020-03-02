package offer;

import java.util.Arrays;

/**
 * @Author JH
 * 扑克牌的顺子
 * 0看做是癞子
 **/
public class IsContinuous {


    public static boolean isContinuous(int[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int count = 0;
        int diff = 0;
        Arrays.sort(arr);
        for (int i = 0;i<arr.length-1;i++) {
            if (arr[i] == 0) {
                count ++;
                continue;
            }
            if (arr[i] == arr[i+1]) {
                return false;
            }
            diff += arr[i+1] - arr[i] - 1;

        }
        return diff-count>0 ? false :true;

    }

    public static void main(String[] args) {
        int[] arr = {12,15,13,11,0};
        System.out.println(isContinuous(arr));
    }

}
