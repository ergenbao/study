package hot100;

import java.util.Map;

/**
 * @ClassName MaxProduct
 * @Description 乘积最大子序列
 * @Author JH
 * @Date 2019/9/20 11:25
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {

        int max =Integer.MIN_VALUE,imax = 1,imin = 1;
        for(int i = 0 ;i<nums.length;i++) {
            if(nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);
            max = Math.max(max,imax);
        }
        return  max;
    }

}
