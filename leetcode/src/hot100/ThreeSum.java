package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return res;
        }
        //排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            //去除重复元素
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i+1,r = nums.length-1,sum = 0;
                while(l < r) {
                  sum = nums[l] + nums[r];
                  //三数之和为0
                  if(sum == - nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(l);
                    list.add(r);
                    res.add(list);
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                    while(l<r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    r--;
                  } else if(sum > -nums[i]) {
                      while(l<r && nums[r]==nums[r-1]) {
                          r--;
                      }
                      r--;
                  } else {
                      while(l<r && nums[l] == nums[l+1]) {
                          l++;
                      }
                      l++;
                  }
                }
            }

        }
        return res;
    }
}
