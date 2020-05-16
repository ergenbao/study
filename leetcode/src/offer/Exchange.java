package offer;

/**
 *  调整数组顺序使奇数位于偶数前面
 * */
public class Exchange {
    public int[] exchange(int[] nums) {
        //i从左向右找到偶数，j从右向左找到奇数，交换
        int i = 0,j = nums.length-1,tmp;
        while(i < j) {
            while(i <j && (nums[i] &1) == 1) {
                i++;
            }
            while(i < j && (nums[j] & 1) == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] =nums[j];
            nums[j] = tmp;
        }
        return nums;
    }
}
