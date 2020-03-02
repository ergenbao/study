package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LongestConsecutive
 * @Description 最长序列字串
 * @Author JH
 * @Date 2019/9/12 14:38
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int res = 0;
        for(int num : nums) {
            if(!set.contains(num-1)) {
                int temp = 1;
                while(set.contains(num + 1)) {
                    temp ++;
                    num ++;
                }
                res = Math.max(temp,res);
            }
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                map.put(num,left + right + 1);
                map.put(num - left,right + left + 1);
                map.put(num + right,right + left +1);
                res = Math.max(res,left + right + 1);
            }
        }
        return res;
    }

}
