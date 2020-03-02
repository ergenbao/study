package hot100;

/**
 * @ClassName DailyTemperatures
 * @Description 每日温度
 * @Author JH
 * @Date 2019/11/20 19:15
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        //从右向左遍历
        for(int i = length - 2;i >= 0;i--) {
            // j+=result[j]是利用已经有的结果进行跳跃
            for(int j = i+1;j<length;j+=result[j]) {
                if(T[j] > T[i]) {
                    result[i] = j-i;
                    break;
                    //遇到0表示后面不会有更大的值，那当然当前值就应该为0
                } else if(result[j] == 0){
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
