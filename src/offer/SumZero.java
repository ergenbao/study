package offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JH
 * 在一个数组中给定找到三个数的和为0
 **/
public class SumZero {

    public static List<ArrayList<Integer>> threeSum(int[] nums) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums==null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i<nums.length-2;i++) {
                int left = i+1;
                int right = nums.length-1;
                if (i == left) {
                    continue;
                }
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        if (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        if(left<right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if(sum >0) {
                        right--;
                    } else {
                        left ++;
                    }
                }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {-1,-2,-3,0,1,5,6};
        List<ArrayList<Integer>> arrayLists = threeSum(arr);
        System.out.println(arrayLists);

    }
}
