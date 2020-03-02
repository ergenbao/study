package offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: JH
 * @Date: 2019/4/13 21:27
 * 一个数组中只有两个数出现了一次，请找出这两个数
 * 用hashmap
 */
public class FindNumsAppearOnce {

    public static void find(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int c : arr) {
            if (map.containsKey(c)) {
                map.put(c,2);
            }else {
                map.put(c,1);
            }
        }

        Set<Integer> set = map.keySet();
        for (int i : set) {
            if (map.get(i) == 1) {
                System.out.println(i);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,2,3,5};
        find(arr);
    }

}
