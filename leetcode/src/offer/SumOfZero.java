package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JH
 * @Date: 2019/4/16 21:30
 *
 */
public class SumOfZero {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i= 0 ; i< nums.length - 2;i++) {
            //去除重复元素
            if(nums[i] == nums[i+1]) {
                continue;
            }

            int l = i + 1 , r = nums.length- 1,sum = 0 ;
            while(l < r) {
                sum = nums[l] + nums[r];
                if(sum == -nums[i]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                    while(l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    r--;
                } else if(sum > -nums[i]) {
                    //去除重复元素
                    while(l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    r--;
                } else{
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,4};
        System.out.println(threeSum(arr));
    }
}
