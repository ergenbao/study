package offer;

/**
 * @Author JH
 *从1到整数n中1出现的次数
 **/
public class CountOne {

    public static long countOne(long n) {
        long count = 0; // 1的个数
        long i = 1;  // 当前位
        long current = 0,after = 0,before = 0;

        while((n / i) != 0) {
            before = n / (i * 10); // 高位
            current = (n / i) % 10; // 当前位
            after = n - (n / i) * i;  // 低位

            if (current == 0)
                //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
                count = count + before * i;
            else if(current == 1)
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count = count + before * i + after + 1;
            else if (current > 1)
                // 如果大于1,出现1的次数由高位决定,（高位数字+1）* 当前位数
                count = count + (before + 1) * i;
            //前移一位
            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOne(469));
    }


    public static long solution(long n) {
        //1的个数
        long count = 0;
        //当前位
        long i = 1;
        long cur = 0,after = 0,before = 0;
        while (n / i > 0) {
            before = n / (i * 10);
            cur = (n / i) % 10;
            after = n - (n / i) * i;

            if(cur == 0) {
                count = count + before * i;
            }else if(cur == 1) {
                count = count + before * i + after +1;
            }else if(cur > 1) {
                count = count + (before + 1)*i;
            }
            i = i * 10;
        }
        return count;
    }

}
