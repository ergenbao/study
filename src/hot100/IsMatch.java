package hot100;


/**
 * @ClassName IsMatch
 * @Description 正则表达式匹配  动态规划
 * @Author JH
 * @Date 2019/8/28 14:08
 */
public class IsMatch {

    enum Result{
        TRUE,FALSE
    }

    Result[][] memo;

    public boolean isMatch(String text,String pattern) {
            memo = new Result[text.length() + 1][pattern.length() + 1];
            return dp(0,0,text,pattern);
    }
    private boolean dp(int i ,int j ,String text ,String pattern) {
        if(memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if(j == pattern.length()) {
            ans = i == text.length();
        } else {
            //第一个字符是否匹配
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            //如果pattern的第二个字符为*  1.text角标不动、pattern移动两个 x* 对匹配结果无影响  2.第一个字符匹配 pattern不动、text移动一个
            if(j + 1 < pattern.length() && pattern.charAt(j+1) == '*') {
                ans = (dp(i,j+2,text,pattern) || first_match && dp(i+1,j,text,pattern));
            }else {
                //如果pattern第二个字符不为* pattern、text 角标都移动一个、继续比较
                ans = first_match && dp(i+1,j+1,text,pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
