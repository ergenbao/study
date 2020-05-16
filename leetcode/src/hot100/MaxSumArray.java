package hot100;

/**
 * @ClassName MaxSumArray
 * @Description 最大子序和 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @Author JH
 * @Date 2019/9/5 9:54
 */
public class MaxSumArray {

    public int maxSumArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num : nums) {
            //如果sum大于0，表示下个值加上sum会变大
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans =Math.max(ans,sum);
        }
        return ans;
    }

}
