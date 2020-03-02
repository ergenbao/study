package hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis
 * @Description 括号生成
 * @Author JH
 * @Date 2019/9/2 16:49
 */
public class GenerateParenthesis {

    private static List<String> generateParenthesis(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        if (n == 0) {
            return new LinkedList<>();
        }
        LinkedList<String> list0 = new LinkedList<>();
        //0组括号时
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        //1组括号时
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::print);
    }
}
