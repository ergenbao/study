package offer;


import java.util.ArrayList;

/**
 * @Author: JH
 * @Date: 2019/4/14 20:39
 * 输出所有和为s的连续正数序列
 */
public class FindContinuosSequence {

        public ArrayList<ArrayList<Integer>> findContinuosSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
            if(sum == 1) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                result.add(list);
            }else if(sum == 2) {
                return result;
            }

            int start = 1;
            int end = 2;
            while (start < (sum+1) / 2) {
               int curSum = sum(start,end);
               if(curSum == sum) {
                   ArrayList<Integer> list = new ArrayList<Integer>();
                   for (int i =start ; i<=end;i++) {
                        list.add(i);
                   }
                   result.add(list);
                   start++;
                   end++;
               } else if(curSum > sum) {
                   start++;
               }else {
                   end ++;
               }
            }
            return result;

        }

        public int sum(int start,int end) {
            int sum = 0;
            for(int i = start;i<=end;i++) {
                sum+=i;
            }
            return sum;
        }

}
