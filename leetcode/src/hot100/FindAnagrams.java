package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FindAnagrams
 * @Description 找到字符串中所有字母异位词
 * @Author JH
 * @Date 2019/11/18 15:13
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s,String t) {
        //用数组记录答案
        List<Integer> res = new ArrayList<>();
        int left = 0 , right = 0;
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c,needs.getOrDefault(c,0) + 1);
        }
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)) {
                window.put(c1,window.getOrDefault(c1,0) + 1);
                if(window.getOrDefault(c1,0).equals(needs.get(c1))) {
                    match ++;
                }
            }
            right ++;
            while (match == needs.size()) {
                // 如果window的大小合适，就把起始索引left加入结果
                if(right - left == t.length()) {
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if(needs.containsKey(c2)) {
                    window.put(c2,window.get(c2)-1);
                    if (window.getOrDefault(c2,0) < needs.get(c2)) {
                        match --;
                    }
                }
                left ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
     int x = 15;
       while(x > 0) {
           System.out.println(x & 1);
           x = x >>>1;
       }

    }
}
