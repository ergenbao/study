package hot100;

/**
 * @ClassName FindTargetSumWays
 * @Description 目标和
 * @Author JH
 * @Date 2019/11/19 10:02
 */
public class FindTargetSumWays {
//    int count = 0;
//    public int findTargetSumWays(int[] nums ,int target) {
//        calculate(nums,0,0,target);
//        return count;
//    }
//    public void calculate(int[] nums,int i,int sum,int target) {
//        if(i == nums.length) {
//            if(sum == target ) {
//                count ++;
//            }
//        } else {
//            calculate(nums,i+1,sum + nums[i],target);
//            calculate(nums,i+1,sum-nums[i],target);
//        }
//    }
    //可以将这组数看成两部分，P和N，其中P使用正号，N使用负号，有
    //sum(P)-sum(N)=target
    //sum(P)-sum(N)+sum(P)+sum(N) = target + sum(P) + sum(N)
    //2*sum(P) = target + sum(nums)
    //因此只要找到一个子集，令他们都取正号，并且和等于  (target + sum(nums)) /2,就证明存在解

    public int findTargetSumWays(int[] nums,int target) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) /2 ;
        //dp[i] 代表合成i有多少种方法，dp[i] += dp[i-num];
        int[] dp = new int[target +  1];
        dp[0] = 1;
        for(int num : nums) {
            for(int i = target;i >= num;i--) {
                dp[i] +=dp[i-num];
            }
        }
        return dp[target];
    }
}
