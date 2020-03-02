package hot100;

import java.util.*;

/**
 * @ClassName GroupAnagrams
 * @Description 字母异位词分组
 * @Author JH
 * @Date 2019/9/4 18:46
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String,List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count,0);
            for(char c : s.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ;i<26;i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) {
                ans.put(key,new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}