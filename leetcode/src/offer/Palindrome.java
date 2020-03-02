package offer;

import java.util.Scanner;

/**
 * @Author JH
 * 判断一个字符串是否是回文
 **/
public class Palindrome {
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if(chars[i] != chars[chars.length-i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("请输入一个字符串：");

        while (scanner.hasNext()) {
            System.out.println("请输入一个字符串：");
            String s = scanner.nextLine();
            System.out.println(isPalindrome(s));
        }



    }

}
