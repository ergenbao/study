package hot100;

/**
 * @ClassName MaxCoins
 * @Description 戳气球
 * @Author JH
 * @Date 2019/11/7 9:54
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //dp[i][j] 代表i->j的最大值
        int[][] dp = new int[n+2][n+2];
        //左右+1方便操作  nums[-1] = nums[n] = 1;
        int[] arr = new int[n+2];
        for(int i=1;i<arr.length-1;i++){
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[arr.length-1] = 1;
        //第一层循环j 代表着区间长度
        for (int j = 2;j<arr.length;j++) {
            //第二次循环i代表区间首元素位置
            for (int i=0;i<arr.length - j;i++) {
                //第三层循环，将区间以k来进行分隔，k为最后一个戳破的气球
                for (int k = i+1;k<i+j;k++) {
                    dp[i][i+j] =Math.max(dp[i][i+j],dp[i][k]+dp[k][i+j]+arr[i] * arr[k] * arr[i+j]);
                }
            }
        }
        return dp[0][arr.length -1];

    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        int[] nums = {3,5,8,4,9};
        int i = maxCoins.maxCoins(nums);
    }
}
