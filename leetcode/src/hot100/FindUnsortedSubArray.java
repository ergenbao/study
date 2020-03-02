package hot100;

/**
 * @ClassName FindUnsortedSubArray
 * @Description 最短无序连续子数组
 * @Author JH
 * @Date 2019/11/20 10:45
 */
public class FindUnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        //遍历过的值里面的最大值
        int max = nums[0];
        //遍历过的值里面的最小值
        int min = nums[len -1];
        //l 需要排序的左边界  r 需要排序的右边界
        int l =len - 1, r = 0;
        for(int i = 0;i<len;i++) {
            //如果是递增，nums[i] 应该越来越大， 如果  max > nums[i] 表示nuns[i]是乱序的
            //最后 r右侧的数据应该都比max大
            if(max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }
            if(min < nums[len -i-1]) {
                l = len -i -1;
            } else {
                min = nums[len -i -1];
            }
        }
        return r-l < 1 ?0 :r - l + 1;
    }

}
