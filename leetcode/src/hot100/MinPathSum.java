package hot100;

/**
 * 最小路径和 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * */
public class MinPathSum {
    public int minPathSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0];
        //初始化第一行
        for(int i = 1;i < n;i++) {
            dp[0][i] = dp[0][i-1] + nums[0][i];
        }
        //初始化第一列
        for(int j = 1;j < m;j++) {
            dp[j][0] = dp[j-1][0] + nums[j][0];
        }
        for(int i=1;i<m;i++) {
            for(int j =1;j<n;j++) {
                dp[i][j] = nums[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][m-1];
    }
}
