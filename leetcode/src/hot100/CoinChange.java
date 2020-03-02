package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CoinChange
 * @Description 零钱兑换
 * @Author JH
 * @Date 2019/11/11 10:26
 */
public class CoinChange {

  /**
  * 零钱兑换
  *
  * @param coins 硬币金额数组
   * @param amount 目标数量
  * @return int
  * @author JH
  * @date 2019/11/11 10:57
  */
    public int coinChange1(int[] coins,int amount) {
        if(amount == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            //金额不可达
            if (amount - coin < 0){ continue;}
            int subProb = coinChange1(coins,amount-coin);
            //子问题无解
            if (subProb == -1){continue;}
            ans = Math.min(ans,subProb+1);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int coinChange2(int[] coins,int amount) {
        Map<Integer,Integer> memo = new HashMap<>();
        return helper(memo,coins,amount);
    }
    public int helper(Map<Integer,Integer> memo,int[] coins,int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo.getOrDefault(amount,-2) != -2) {
            return memo.get(amount);
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subProb = helper(memo,coins,amount-coin);
            //子问题无解
            if (subProb == -1){continue;}
            ans = Math.min(ans,subProb+1);
        }
        memo.put(amount,ans == Integer.MAX_VALUE ? -1 : ans);
        return memo.get(amount);

    }


    public int coinChange(int[] coins,int amount) {
        int[] dp = new int[amount+1];
        //先将数组填充
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i= 1;i <=amount ;i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i],dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] arr = {1,2,5};
        cc.coinChange(arr,11);
    }




}
