package offer;

/**
 * @Author: JH
 * @Date: 2019/3/28 21:12
 * 请实现一个函数，将字符串中的空格替换成一个"%20"
 */
public class ReplaceSpace {


    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Hello World!!!    "));
    }


}
