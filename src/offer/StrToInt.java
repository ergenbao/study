package offer;

/**
 * @Author JH
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false。
 **/
public class StrToInt {

    public static int strToInt(String s) {
        char[] charArr = s.toCharArray();
        int mark = 0 ;
        if (charArr[0] == '-') {
            mark = 1;
        }
        long num = 0;
        for (int i = charArr.length -1;i>=0;i--) {
            if(charArr[i]-'0' >= 0 && charArr[i] - '0' <= 9){
                num+= (charArr[i]-'0') * Math.pow(10,charArr.length-i-1);
                if (num > Integer.MAX_VALUE) {
                    throw new RuntimeException("it is out range of Integer.MAX_VALUE");
                }
            }else {
                throw new RuntimeException("it is not a num");
            }
        }
        return mark == 1 ? (int)-num:(int)num;
    }

    public static void main(String[] args) {
        String num = "-12346789";
        System.out.println(strToInt(num));
    }


}
