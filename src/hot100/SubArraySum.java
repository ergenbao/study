package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SubArraySum
 * @Description 和为k的子数组
 * @Author JH
 * @Date 2019/11/19 18:54
 */
public class SubArraySum {
    public int subarraySum(int[] nums,int k) {
        if(nums == null || nums.length == 0 ) {
            return 0;
        }
        //dp[i]表示前i个数的和
        int[] dp = new int[nums.length + 1];
        for(int i= 1;i<=nums.length;i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<dp.length;i++) {
            if(map.containsKey(dp[i]-k)) {
                res = res + map.get(dp[i] -k);
            }
            map.put(dp[i],map.getOrDefault(dp[i],0) + 1);
        }
        return  res;
    }
}
