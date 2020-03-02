package offer;

import java.util.HashMap;


/**
 * @Author JH
 * 数组中有一个数字出现的次数超过数组长度的一半，找出这个数字
 **/
public class MoreThanHalfNum {
    public static int moreThanHalfNum(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int halfLength = arr.length / 2;
        for(int i = 0 ;i< arr.length;i++) {
            if(map.containsKey(arr[i])) {
                int num = map.get(arr[i]);
                num = num +1;
                map.put(arr[i],num);
                if(num >halfLength) {
                    return arr[i];
                }
            }else {
                map.put(arr[i],1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8,8,8,8,8,8,8};
        System.out.println(moreThanHalfNum(arr));
    }


}
