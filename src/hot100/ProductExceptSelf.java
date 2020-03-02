package hot100;

/**
 * @ClassName ProductExceptSelf
 * @Description 除自身以外数组的乘积
 * @Author JH
 * @Date 2019/10/16 13:38
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k =1;
        for (int i = 0 ;i < res.length;i++) {
            res[i] = k;
            //此时数组存储的是除去当前元素左边的元素乘积
            k = k * nums[i];
        }
        k = 1;
        for (int i = res.length - 1;i >= 0;i--) {
            //k为该数右边的乘积
            res[i] *= k;
            //此时数组等于左边的 * 该数右边的
            k *= nums[i];
        }
        return res;

    }
}
