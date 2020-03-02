package offer;

import java.util.HashMap;

/**
 * @Author JH
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内，找出数组中任意一个重复的数字
 **/
public class Duplicate {

    public static boolean findDuplicate(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<arr.length;i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                System.out.println(arr[i]);
              return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7,7};
    }

}
