package hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName WordBreak
 * @Description 单词拆分
 * @Author JH
 * @Date 2019/9/17 11:21
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>  wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1 ; i <= s.length() ; i++) {
            for(int j = 0 ;j < i;j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "0123456";
        System.out.println(s.substring(0,6));
    }
}
