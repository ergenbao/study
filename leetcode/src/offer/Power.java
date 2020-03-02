package offer;

/**
 * @Author: JH
 * @Date: 2019/3/30 19:24
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {


    public static void main(String[] args) {
        System.out.println(solution(2.0d,-1));
    }

    public static double solution(double base,int exponent) {
        if(base == 0 && exponent < 0) return 0.0d;
        if (exponent == 0)return 1;
        double a = 1.0d;
        int temp =  exponent;
        exponent = abs(exponent);
        while (exponent > 0){
            a *=base;
            exponent--;
        }
        if (temp < 0){
            a = 1 / a;
        }
        return a;
    }
    public static int abs(int a){
        return a>0 ?a:-a;
    }
}
