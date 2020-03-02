package offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JH
 * 四数之和
 **/
public class FourNum {

    public List<List<Integer>> fourNum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i< nums.length -3 ; i++) {
            //去除可能重复的数据
            if (i == 0 || (i > 0 && nums[i] != nums [i -1])) {
                int min_sum = nums[i] + nums[i+1] + nums[i+2]+nums[i+3];
                int max_sum = nums[i] + nums[nums.length-3] + nums[nums.length-2]+nums[nums.length-1];
                if( min_sum > target || max_sum < target) {
                    continue;
                }
                 for (int j = i +1 ; j <nums.length -2 ; j ++) {
                     if (j ==  i +1 || (j >1 && nums[j] != nums[j -1])) {
                          min_sum = nums[i] + nums[j] + nums[j +1]+ nums[j+2];
                          max_sum = nums[i] + nums[j] + nums[nums.length-2]+nums[nums.length-1];
                         if( min_sum > target || max_sum < target) {
                             continue;
                         }
                         int l = j +1;
                         int r = nums.length -1;
                         while (l < r) {
                             int sum = nums[i] + nums[j]+nums[l] + nums[r];
                             if (sum == target) {
                                 ArrayList<Integer> list = new ArrayList<>();
                                 list.add(nums[i]);
                                 list.add(nums[j]);
                                 list.add(nums[l]);
                                 list.add(nums[r]);
                                 result.add(list);
                                 while (l < r && nums[l] == nums[l+1]) {
                                     l++;
                                 }
                                 l++;
                                 while (l < r && nums[r] == nums[r -1]) {
                                     r--;
                                 }
                                 r--;
                             }else if (sum > target){
                                 while (l < r && nums[r] == nums[r -1]) {
                                     r--;
                                 }
                                 r--;
                             } else {
                                 while (l < r && nums[l] == nums[l+1]) {
                                     l++;
                                 }
                                 l++;
                             }
                         }
                     }
                 }
            }
        }
        return result;



    }

}
