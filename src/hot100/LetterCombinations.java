package hot100;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LetterCombinations
 * @Description 电话号码的字母组合  队列先进先出
 * @Author JH
 * @Date 2019/9/2 9:50
 */
public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        //创建一个队列
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("2358");
        strings.forEach(System.out::println);
    }

}
