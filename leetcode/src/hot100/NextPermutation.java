package hot100;

//下一个排列
//定义一个指针，从尾部向前，找到第一个不满足nums[i+1]<nums[i]的i，
// 再从尾向前找到第一个不满足nums[i]>=nums[j]的j值，swap(nums,i,j)
//逆序nums[i+1,length-1]
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i >=0) {
            int j = nums.length -1;
            while(i <j && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums,int start) {
        int j = nums.length -1;
        while(start < j) {
            swap(nums,start,j);
            start++;
            j--;
        }
    }
}
