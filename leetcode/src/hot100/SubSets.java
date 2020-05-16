package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubSets
 * @Description 子集 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * @Author JH
 * @Date 2019/9/9 9:39
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,res,new ArrayList<Integer>());
        return res;
    }
    private void backTrack(int i ,int[] nums ,List<List<Integer>> res,ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for(int j = i;j<nums.length;j++) {
            temp.add(nums[j]);
            backTrack(j+1,nums,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
