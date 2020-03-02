package hot100;

/**
 * @ClassName MajorityElement
 * @Description 求众数
 * @Author JH
 * @Date 2019/9/21 15:18
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for(int i=1 ;i< nums.length ;i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
                continue;
            }
            if(nums[i] == res) {
                count ++;
            }else {
                count --;
            }
        }
        return res;
    }
}
