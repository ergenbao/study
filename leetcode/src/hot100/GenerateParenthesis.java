package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateParenthesis
 * @Description 括号生成
 * @Author JH
 * @Date 2019/9/2 16:49
 */
public class GenerateParenthesis {

    private static List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if (n == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> list0 = new ArrayList<>();
        //0组括号时
        list0.add("");
        result.add(list0);
        ArrayList<String> list1 = new ArrayList<>();
        //1组括号时
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            ArrayList<String> temp = new ArrayList<>();
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
