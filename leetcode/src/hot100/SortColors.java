package hot100;

/**
 * @ClassName SortColors
 * @Description 颜色分类
 * @Author JH
 * @Date 2019/9/6 10:33
 */
public class    SortColors {
    public void sortColors(int[] nums) {
        //l : 数字0的最右边界   r：数字2的最左边界
        int i=0,l=0,r = nums.length-1;
        while(i <= r) {
            if(i < l ||nums[i] ==1) {
                i++;
            } else if(nums[i] == 0) {
                swap(nums,i,l++);
            } else if(nums[i] == 2) {
                swap(nums,i,r--);
            }
        }
    }

    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,1,0};
        new SortColors().sortColors(nums);
        for(int num : nums) {
            System.out.print(num);
        }
    }
}
