package hot100;

/**
 * @ClassName FindDuplicate
 * @Description 寻找重复数
 * @Author JH
 * @Date 2019/10/22 18:40
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len -1;
        while(left < right) {
            int mid = (left + right) >>> 1;
            int counter = 0 ;
            for(int num : nums) {
                if(num <= mid) {
                    counter ++ ;
                }
            }
            if(counter > mid) {
                right = mid;
            }else {
                left = mid +1;
            }
        }
        return left;
    }
}
