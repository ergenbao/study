package offer;

import java.util.Arrays;

/**
 * @Author: JH
 * @Date: 2019/4/16 22:15
 */
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {

        if(nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int min = 0;
        for(int i = 0 ; i< nums.length -2 ; i++) {
            int l = i+1 , r = nums.length -1 ,  sum = 0;
            min = Math.abs(nums[i] + nums[l] + nums[r]-target);
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                min = Math.min(min,Math.abs(nums[i] + nums[l] + nums[r]-target));
                if(sum > target) {
                    while(l < r && nums[r] == nums[r-1] ) {
                        r--;
                    }
                    r--;
                } else if(sum < target) {
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                } else if(sum == target) {
                    return sum;
                }
            }
        }

        return min;

    }

    public static void main(String[] args) {
        int[] arr = {-1,2,1,4};
        System.out.println(threeSumClosest(arr,1));
    }



}
