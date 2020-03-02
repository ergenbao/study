package hot100;

/**
 * @ClassName MaxProfit
 * @Description 买卖股票的最佳时机
 * @Author JH
 * @Date 2019/9/11 16:48
 */
public class MaxProfit {
    public int maxProfit(int[] price) {
        int minpirce = Integer.MAX_VALUE;
        int maxprofit = 0 ;
        for (int i = 0 ;i < price.length;i++) {
            if(price[i] < minpirce) {
                minpirce = price[i];
            } else if(price[i] - minpirce > maxprofit){
                maxprofit = price[i] - minpirce;
            }
        }
        return maxprofit;
    }
}
