package offer;

/**
 * @Author JH
 * .写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 **/
public class Add {

    public static int add(int num1,int num2) {

        while (num2 != 0) {
            //个位
            int temp = num1 ^ num2;
            //进位
            num2 = (num1 & num2) <<1;
            num1 = temp;
         }
         return num1;

    }


    public static void main(String[] args) {
        System.out.println(add(10,20));
    }

}
