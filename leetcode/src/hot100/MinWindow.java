package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MinWindow
 * @Description 最小覆盖子串
 * @Author JH
 * @Date 2019/9/6 11:13
 */
public class MinWindow {
    public String minWindow(String s,String t) {
        if(s.length() == 0 || t.length() == 0) {
            return "";
        }
        int left = 0 ,right = 0,start = 0 ,minLength = Integer.MAX_VALUE;
        String res = s;
        //相当于两个计数器
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();
        for(char c : t.toCharArray()) {
            int count = needs.getOrDefault(c,0);
            needs.put(c,count +1);
        }
        //记录window中y已经有d多少个字符符合要求了
        int match = 0;
        while(right < s.length())  {
           char c1 = s.charAt(right);
           //是t中的字符
           if(needs.getOrDefault(c1,0) >0) {
               window.put(c1,window.getOrDefault(c1,0)+1);
               if(window.get(c1) .equals(needs.get(c1))) {
                   match++;
               }
           }
           right ++;
           //window中的字符串已经符合needs的要求了
            while(match == needs.size()) {
                //跟新结果
                if(right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }
                char c2 = s.charAt(left);
                if(needs.getOrDefault(c2,0) > 0) {
                    window.put(c2,window.getOrDefault(c2,0)-1);
                    if(window.get(c2) < needs.get(c2)) {
                        match -- ;
                    }
                }
                left ++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start,start + minLength);
    }
}
