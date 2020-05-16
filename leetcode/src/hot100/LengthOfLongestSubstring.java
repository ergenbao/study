package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

}
