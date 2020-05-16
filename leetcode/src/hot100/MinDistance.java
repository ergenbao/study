package hot100;

/**
 * @ClassName MinDistance
 * @Description 编辑距离 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @Author JH
 * @Date 2019/9/5 20:04
 */
public class MinDistance {
    public int minDistance(String word1,String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]:word1的前i个字符，变成word2的前j个字符，最少需要多少步
        int[][] dp = new int[m+1][n+1];
        //第一行
        for(int i =1 ;i<n+1;i++ ) {
            //插入
            dp[0][i] = dp[0][i- 1] + 1;
        }
        //第一列
        for(int j =1 ;j<m+1;j++) {
            //删除
            dp[j][0] = dp[j-1][0]+1;
        }
        for(int i =1 ;i<m+1;i++) {
            for(int j = 1;j<n+1;j++) {
                //当 word1[i] == word2
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //dp[i-1][j-1]表示替换操作,dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1 ;
                }
            }
        }
        return dp[m][n];
    }
}
