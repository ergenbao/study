package hot100;


import java.util.Stack;

/**
 * @ClassName IsValid
 * @Description 有效的括号
 * @Author JH
 * @Date 2019/9/2 13:49
 */
public class IsValid {

    public boolean isValid(String s) {
      if("".equals(s)) {
          return true;
      }
        Stack<Character> stack = new Stack<>();
      for (char c:s.toCharArray()) {
          if('(' == c){
              stack.push(')');
          }else if('['==c){
              stack.push(']');
          }else if('{' == c){
              stack.push('}');
          }else if(stack.isEmpty() || c != stack.pop()){
              return false;
          }
      }
      return stack.isEmpty();

    }

}
