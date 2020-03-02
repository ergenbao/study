package offer;

/**
 * @Author: JH
 * @Date: 2019/3/30 19:03
 * 输入一个整数，输出该数二进制表示中1的个数,其中负数用补码表示
 */
public class NumberOf1 {
    public int numberOf1 (int n) {
        int count = 0;
        while(n!=0){
            count+=n&1;
            n=n>>>1;
        }
        return count;

    }

    public int solution(int n) {
        int count =0 ;
        while (n != 0) {
            count+=n&1;
            n = n>>>1;
        }
        return count;
    }
}
