package hot100;

import java.util.LinkedList;

/**
 * @ClassName DecodeString
 * @Description 字符串解码
 * @Author JH
 * @Date 2019/11/12 13:57
 */
public class DecodeString {

    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if(c == '[') {
                //将当前倍数、字符入栈，置0
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0 ;
                res = new StringBuilder();
            } else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                // [ ]之间的字符 * 倍数
                for(int i = 0;i< cur_multi;i++) {
                    tmp.append(res);
                }
                //stack_res.removeLast()[ 之前的字符
                res = new StringBuilder(stack_res.removeLast() + tmp);
                //为了计算多位的数值
            } else if(c >='0' && c<='9') {
                multi  = multi * 10 + Integer.parseInt(c +"");
            //字符串直接添加
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        decodeString(s);
    }
}
