package offer;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author JH
 * 输入一个整数，返回倒序的字符串
 **/
public class ReverseIntToStr {

    public static String reverseIntToStr(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("请输入一个整数");
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            System.out.println("请输入一个整数");
            System.out.print(reverseIntToStr(num));
        }
    }

}
