package hot100;

import java.util.Map;
import java.util.Stack;

/**
 * @ClassName LongestValidParentheses
 * @Description 最长有效括号
 * @Author JH
 * @Date 2019/9/3 18:55
 */
public class LongestValidParentheses {

    /**
    * 栈实现
    *
    * @param s 字符串
    * @return int
    * @author JH
    * @date 2019/9/3 19:06
    */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i =0 ;i<s.length();i++) {
            //遇到的每个'('，我们将它的下标放入栈中
            if(s.charAt(i)=='(') {
                stack.push(i);
            //对于遇到的每个')'，我们我们弹出栈顶元素，并将当前元素的下标与新的栈顶元素做差
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }

    //动态规划实现
//    public int longestValidParentheses(String s) {
//        int maxans = 0;
//        int[] dp = new int[s.length()];
//        for(int i = 1; i < s.length();i++) {
//            if(s.charAt(i) == ')') {
//                if(s.charAt(i-1) == '(') {
//                    dp[i] = (i>2 ? dp[i -2] :0) +2;
//
//                } else if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1)=='(') {
//                    dp[i] = dp[i-1] + ((i-dp[i-1]) >=2? dp[i-dp[i-1]-2]:0)+2;
//                }
//                maxans = Math.max(maxans,dp[i]);
//            }
//        }
//        return maxans;
//    }

}
