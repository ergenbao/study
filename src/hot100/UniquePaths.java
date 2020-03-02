package hot100;

/**
 * @ClassName UniquePaths
 * @Description 不同路径 动态规划 到达m、n点的方式  dp[m][n] = dp[m-1][n] + dp[m][n-1];
 * @Author JH
 * @Date 2019/9/5 13:56
 */
public class UniquePaths {
    public int uniquePaths(int m , int n) {
        int[][] dp = new int[m][n];
        for (int i = 0 ;i< n;i++) {
            dp[0][i] = 1;
        }
        for (int j = 0;j<m;j++) {
            dp[j][0] = 1;
        }
        for(int j =1 ;j<m;j++) {
            for(int i = 1;i < n;i++) {
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }
        return dp[m-1][n-1];
    }

}
