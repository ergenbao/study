package hot100;

import java.util.Arrays;

/**
 * @ClassName LengthOfLIS
 * @Description 最长上升子序列
 * @Author JH
 * @Date 2019/10/30 16:50
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 ) {
            return 0;
        }
        int[] dp  = new int[nums.length];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 0;i<nums.length;i++) {
            for (int j = 0 ;j < i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] =Math.max(dp[i],dp[j+1]);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0 ,j = res ;
            while (i < j) {
                int m = (i +j) / 2;
                if(tails[m] < num) {
                    i = m +1;
                }else {
                    j = m;
                }
            }
            tails[i] = num;
            if(res == j) {
                res ++;
            }
        }
        return res;
    }

}
