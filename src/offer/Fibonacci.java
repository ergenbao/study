package offer;

/**
 * @Author: JH
 * @Date: 2019/3/30 16:12
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        if (n < 1) return 0;
        int [] fibonacci = new int[2];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        n-=2;
        while (n > 0){
            int temp = fibonacci[0] + fibonacci[1];
            fibonacci[0] = fibonacci[1];
            fibonacci[1] = temp;
            n--;
        }
        return fibonacci[1];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

}
