package hot100;

/**
 * 搜索旋转排序数组
 * */
public class Search {
    public int search(int[] nums,int target) {
        int lo = 0,hi = nums.length -1;
        while(lo <= hi) {
            int mid = lo+(hi-lo)/2;
            if(nums[mid] == target) {
                return mid;
            }
            //先根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
            //在左半段
            if(target >= nums[0]) {
                //若 mid 在右半段，则将 mid 索引的值改成 inf
                if(nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
             //在右半段
            }else {
                //若 mid 在左半段，则将 mid 索引的值改成 -inf
                if(nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if(nums[mid] < target) {
                lo = mid+1;
            }else {
                hi = mid -1;
            }
        }
        return -1;
    }
}
