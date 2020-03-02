package bigsum;

/**
 * @Author: JH
 * @Date: 2019/4/24 8:32
 * 两个大数相加
 */
public class Add {

    public static String add(String n1,String n2) {
        //翻转字符串
         n1 = new StringBuilder(n1).reverse().toString();
         n2 = new StringBuilder(n2).reverse().toString();
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(n1.length(),n2.length());

        if(n1.length() < n2.length()) {
            for(int i = n1.length(); i < n2.length();i++) {
                n1 += "0";
            }
        } else if(n1.length() > n2.length()) {
            for(int i = n2.length();i < n1.length();i++) {
                n2 += "0";
            }
        }
        //进位
        int c = 0;
        for(int i = 0 ; i<maxLength ;i++) {
            int sum = (n1.charAt(i) - '0') +(n2.charAt(i) - '0')+ c;
            int ap = sum % 10;
            result.append(ap);
            c = sum /10;
        }

        if(c > 0) {
            result.append(c);
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(add("1001","900"));
    }
}
