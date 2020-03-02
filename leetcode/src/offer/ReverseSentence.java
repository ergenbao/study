package offer;

import java.util.Stack;

/**
 * @Author JH
 * 反转字符串
 **/
public class ReverseSentence {

    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (char c :chars) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return String.valueOf(sb);

    }

    public static String leftRotate(String s , int n) {
        n = n % s.length();
        String s1 = s.substring(0,n);
        String s2 = s.substring(n,s.length());
        String s3 = s2+s1;
       return  s3;
    }


    public static void main(String[] args) {
        String s = "abcdef";
       String s1 = leftRotate(s,3);
        System.out.println(s1);
    }

}
