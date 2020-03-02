package hot100;

/**
 * @ClassName MoveZeros
 * @Description 移动零
 * @Author JH
 * @Date 2019/10/22 16:25
 */
public  class MoveZeros {
    public static void moveZeroes(int[] nums){
        int nonZeroIndex = 0;
        for(int i = 0 ;i<nums.length;i++) {
            if(nums[i] != 0) {
                if(i > nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = 0;
                }
                nonZeroIndex ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3,8,0,0,2,3,4,5,0,6};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i);
        }
    }
}
