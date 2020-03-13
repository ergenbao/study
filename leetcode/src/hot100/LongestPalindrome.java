package hot100;

/**
 * 最长回文子串
 * */
public class LongestPalindrome {

    /**
     * 时间复杂度O(n2)
     * 空间复杂度O(n2)
     * dp方法
     * 状态转移方程 dp[i][j] = (s[i] = s[j]) and dp[i+1][j-1]
     * */
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) {
            return s;
        }
        //dp[i][j]表示子串s[i,j]是否为回文子串
        boolean[][] dp = new boolean[len][len];
        //初始化
        for(int i=0;i<len;i++) {
            dp[i][i]=true;
        }
        int maxLen = 1;
        int start = 0;
        for(int j=1;j<len;j++) {
            for(int i =0;i<j;i++) {
                if(s.charAt(i) == s.charAt(j)) {
                    //为了保证[i+1，j-1]不构成区间 需要保证 j-1 - (i+1) +1 <2
                    if(j-i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][j] = false;
                }

                //只要dp[i][j] == true,就表示子串s[i.j]是回文，此时记录回文长度和起始位置
                if(dp[i][j]) {
                    int curLen = j-i+1;
                    if(curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start,start+maxLen);
    }

}
