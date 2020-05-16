package offer;


/**
 * @ClassName IsMatch
 * @Description 正则表达式匹配  动态规划
 * @Author JH
 * @Date 2019/8/28 14:08
 */
public class IsMatch {

  public boolean isMatch(String s,String p) {

      if(s.length() == 0 && p.length() == 0) {
          return true;
      }
      if(s==null || p == null) {
          return false;
      }
      int rows = s.length();
      int cols = p.length();
      //dp[i][j] ：s前i个字符[0,i)是否能匹配p的前j个字符[0,j)。要明确一点，这里是左闭右开的，因此此时是在比较s[i-1]与p[i-1]。
      boolean[][] dp = new boolean[rows+1][cols+1];
      //s 和p 都为空，肯定是可以匹配的，同时当s=a，p=a，那么dp[1][1]=dp[0][0],因此dp[0][0]为true。
      dp[0][0] = true;
      for(int j=1;j<cols;j++){
          //p[j-1]为*可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
          //因此dp[j-2]也要为true，才可以说明前j个为true
          if(p.charAt(j-1)=='*' && dp[0][j-2]) {
              dp[0][j] = true;
          }
      }
      for(int i=1;i<rows;i++) {
          for(int j=1;j<=cols;j++) {
              char nows = s.charAt(i-1);
              char nowp = p.charAt(j-1);
              //两个字符相同
              if(nows == nowp) {
                  dp[i][j] = dp[i-1][j-1];
              } else {
                  if(nowp == '.'){
                      //因为'.'可以为任意字符
                      dp[i][j] = dp[i-1][j-1];
                  } else if(nowp =='*') {
                      //p需要能前移1个。（当前p指向的是j-1，前移1位就是j-2，因此为j>=2）
                      if(j >=2) {
                          char nowpLast = p.charAt(j-2);
                          //只有p[j-2]==s[i-1]或p[j-2]==‘.’才可以让*取1个或者多个字符：
                          if(nowpLast == nows || nowpLast == '.') {
                                //*取一个字符 例子s:aab,p:aab* dp[i][j] = dp[i][j-1];
                                //*取多个字符 列子s：aabb,p：aab*  dp[i][j] = dp[i-1][j]
                                dp[i][j] = dp[i-1][j] || dp[i][j-1];
                          }
                          //不论p[j-2]是否等于s[i-1]都可以删除掉j-1和j-2处字符
                          dp[i][j] = dp[i][j] || dp[i][j-2];
                      }
                      //一个普通字符串
                  } else{
                      dp[i][j] = false;
                  }
              }
          }
      }
      return dp[rows][cols];

  }
}
