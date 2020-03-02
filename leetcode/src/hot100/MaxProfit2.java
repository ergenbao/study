package hot100;

/**
 * @ClassName MaxProfit2
 * @Description 买卖股票的最佳时期包含冷冻期
 * @Author JH
 * @Date 2019/11/4 11:04
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 ){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        int n = prices.length;
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1] = Math.max(dp[0][1],dp[0][0]-prices[1]);
        for(int i = 2;i < n;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
