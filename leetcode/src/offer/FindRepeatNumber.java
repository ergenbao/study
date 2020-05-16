package offer;

import java.util.HashSet;
import java.util.Set;

/**
 *  数组中重复的数字
 * */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(!set.contains(num)) {
               set.add(num);
            }else {
                return num;
            }
        }
        return -1;
    }
}
