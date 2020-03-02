package offer;


import java.util.Arrays;

/**
 * @Author JH
 * 在数组中找出三数之和 ，使之最接近target
 **/
public class ThreeNumSum {

    public static int getSumClosedTarget(int[] nums , int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];

        for (int i =0 ;i<nums.length-2;i++) {
            int l = i +1 ,r = nums.length -1,sum = 0;
            while (l < r) {
                sum = nums[l] + nums[r] + nums[i];
                if(Math.abs(closeSum-target) > Math.abs(sum - target)) {
                        closeSum = sum ;
                }
                if (sum == target) {
                   return sum;
                } else if(sum > target) {
                    r--;
                } else if(sum < target) {

                    l++;
                }

            }
        }

            return closeSum;

    }

    public static void main(String[] args) {

    }

}
