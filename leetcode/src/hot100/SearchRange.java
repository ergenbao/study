package hot100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * */
public class SearchRange {
    public int[] searchRange(int[] nums,int target) {
        int[] arr = {-1,-1};
        int start = 0 ,end = nums.length-1;
        while(start <= end) {
            int mid = (start + end ) /2;
            if(nums[mid] == target) {
                start = end = mid;
                while(start > 0 && nums[start] == nums[start-1]) {
                    start --;
                }
                arr[0] = start;
                while (end < nums.length-1 && nums[end] == nums[end +1]) {
                    end ++;
                }
                arr[1] = end;
                break;
            }else if(nums[mid] > target) {
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        return arr;
    }
}
