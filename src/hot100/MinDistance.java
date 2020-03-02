package hot100;

/**
 * @ClassName MinDistance
 * @Description 编辑距离
 * @Author JH
 * @Date 2019/9/5 20:04
 */
public class MinDistance {
    public int minDistance(String word1,String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        //第一行
        for(int i =1 ;i<n+1;i++ ) {
            dp[0][i] = dp[0][i-1]+1;
        }
        //第一列
        for(int j =1 ;j<m+1;j++) {
            dp[j][0] = dp[j-1][0] + 1;
        }
        for(int i =1 ;i<m+1;i++) {
            for(int j = 1;j<n+1;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1 ;
                }
            }
        }
        return dp[m][n];
    }
}
