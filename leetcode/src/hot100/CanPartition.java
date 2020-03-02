package hot100;

/**
 * @ClassName CanPartition
 * @Description 分割等和子集
 * @Author JH
 * @Date 2019/11/13 14:27
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {
        int size = nums.length;
        int s = 0;
        for (int num : nums) {
            s +=num;
        }
        //如果为奇数，直接返回false
        if((s & 1) == 1) {
            return false;
        }
        int target = s /2;
        //dp[i][j] ： 表示从数组的[0,i]这个子区间内挑选一些正整数，每个数只能用一次，是的这些数的和等于j
        boolean[][] dp = new boolean[size][target+1];
         //先写第一行
        for (int i = 1;i<target+1;i++) {
            if (nums[0] == i) {
                dp[0][i] =true;
            }
        }
        for (int i=1;i<size;i++) {
            for (int j = 0;j < target+1;j++) {
                dp[i][j] = dp[i-1][j];
                if(j == nums[i]) {
                    dp[i][j] = true;
                } else if(j > nums[i]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[size-1][target];
    }

    public static boolean canPartition1(int[] nums) {
        int size = nums.length;
        int s = 0;
        for (int num : nums) {
            s +=num;
        }
        //如果为奇数，直接返回false
        if((s & 1) == 1) {
            return false;
        }
        int target = s /2;

        //从第二行以后，当前行的结果参考了上一行的结果
        boolean[] dp = new boolean[target + 1];
        for (int j =1 ;j < target + 1;j++) {
            if(nums[0] == j) {
                dp[j] = true;
                break;
            }
        }
        for(int i= 1; i < size ;i++) {
            for (int j = target;j >= 0 && j >= nums[i];j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];

    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        canPartition1(nums);
    }
}
