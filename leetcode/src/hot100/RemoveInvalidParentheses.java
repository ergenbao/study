package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RemoveInvalidParentheses
 * @Description 删除无效的括号
 * @Author JH
 * @Date 2019/10/31 15:16
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int leftParentheses = 0;
        int rightParentheses = 0;
        char[] str = s.toCharArray();
        for(char c : str) {
            if(c == '(') {
                leftParentheses += 1;
            } else if(c == ')'){
                if(leftParentheses > 0) {
                    leftParentheses -=1;
                }else {
                    rightParentheses +=1;
                }
            }
        }
        List<String> ans  = new ArrayList<>();
        dfs(s,leftParentheses,rightParentheses,new StringBuilder(s),0,ans);
        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                count += 1;
            }
            if(c == ')') {
                count -= 1;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private void dfs(String s ,int l,int r,StringBuilder sb,int start ,List<String> ans) {
        if(l == 0 && r == 0 && isValid(sb.toString())) {
            ans.add(sb.toString());
            return;
        }
        for(int i = start ; i<s.length();i+=1) {
            if(i != start && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }
            if(s.charAt(i) == '(' || s.charAt(i) == ')') {
                sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if(r > 0 && s.charAt(i) == ')') {
                    dfs(sb.toString(),l,r-1,sb,i,ans);
                } else if(l > 0 && s.charAt(i) == '(') {
                    dfs(sb.toString(),l-1,r,sb,i,ans);
                }
            }

        }

    }
}
