package hot100;

import java.util.HashMap;
import java.util.Map;

//两数之和
public class TwoSum {

    public int[] twoSum(int[] nums,int target) {
        int[] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)){
                arr[1] = i;
                arr[0] = map.get(i);
                return arr;
            }else {
                map.put(target-i,i);
            }
        }
        return null;
    }
}
