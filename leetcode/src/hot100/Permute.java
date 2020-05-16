package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Permute
 * @Description 全排列  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @Author JH
 * @Date 2019/9/4 15:56
 */
public class Permute {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return new ArrayList<>();
        }
        fullSort(nums,0,nums.length-1);
        return result;
    }
    private void  fullSort(int[] nums, int start, int end) {
        if(start == end) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            result.add(list);
        }
        for (int i = start;i<=end ;i++) {
            swap(nums, i, start);
            fullSort(nums,start +1,end);
            swap(nums,i,start);
        }
    }
    private void swap(int[] nums,int start,int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
