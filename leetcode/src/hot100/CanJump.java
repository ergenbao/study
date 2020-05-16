package hot100;

/**
 * 跳跃游戏，给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 从倒数第二个，开始往左判断
 * */
public class CanJump {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int left = nums.length-1;
        for(int i = nums.length -2 ;i >= 0;i--) {
            //表明可以通过i到达left处，所以只需继续判断，能否到达i处即可。
            if(i+nums[i] >= left){
                left = i;
            }
        }
        if(left == 0) {
            return true;
        }
        return false;
    }
}
