package hot100;

/**
 * @ClassName CountSubStrings
 * @Description 回文子串
 * @Author JH
 * @Date 2019/11/20 16:49
 */
public class CountSubStrings {
    //中心扩展法
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0 ; i<s.length() ; i++) {
            //分奇偶考虑
            res += countSegment(s,i,i);
            res += countSegment(s,i,i+1);
        }
        return res;
    }

    //start 往左边跑，end往右边跑，判断s[start,end]是否为回文
    private int countSegment(String s, int start, int end) {
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count ++;
            start --;
            end ++;
        }
        return count;
    }



}
