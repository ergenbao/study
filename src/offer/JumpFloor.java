package offer;

/**
 * @Author: JH
 * @Date: 2019/3/30 16:38
 * 青蛙跳台阶，一次跳一阶或者跳两阶，n阶台阶有多少种跳法
 */
public class JumpFloor {

    public static int jumpFloor(int target) {
        if(target < 1)return 0;
        int [] DP = new int[3];
        DP[0] = 1;
        DP[1] = 2;
        DP[2] = DP[0]+DP[1];
        if(target <= 3){
            return DP[target -1];
        }
        for (int i = 4;i<=target;i++) {
            DP[0] = DP[1];
            DP[1] = DP[2];
            DP[2] = DP[0] + DP[1];
        }
        return DP[2];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloor(5));
    }
}
