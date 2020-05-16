package hot100;

import java.util.*;

/**
 * @ClassName GroupAnagrams
 * @Description 字母异位词分组 时间复杂度O(NK),空间复杂度O(NK),N是strs的长度，K是strs中字符串的最大长度。
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 * @Author JH
 * abbccc 可以表示为：＃1＃2＃3＃0＃0＃0 ...＃0，
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
