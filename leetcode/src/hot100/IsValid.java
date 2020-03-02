package hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName IsValid
 * @Description 有效的括号 map key 括号的左边、 value 括号的右面 定义一个栈
 * @Author JH
 * @Date 2019/9/2 13:49
 */
public class IsValid {

    public boolean isValid(String s) {
        Map<Character,Character> initMap = new HashMap<>(16);
        initMap.put('{','}');
        initMap.put('[',']');
        initMap.put('(',')');
        initMap.put('?','?');
        if(s.length() > 0 && !initMap.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.add('?');
        for(Character c : s.toCharArray()){
            if(initMap.containsKey(c)) {
                stack.addLast(c);
            } else if(!initMap.get(stack.removeLast()).equals(c)) {
                return false;
            }
        }
        return stack.size() == 1;
    }

}
