package hot100;

/**
 * @ClassName Trap
 * @Description 接雨水 对于每堵墙、比较其左边高度最大的墙与其右边高度最大的墙、找出两者的小值,只有
 * 这个小值大于当前墙的高度、才会接雨水、雨水的值为较小值减去当前墙的高度
 * @Author JH
 * @Date 2019/9/4 14:32
 */
public class Trap {
    public int trap(int[] height){
        int length = height.length;
        //左侧最高的墙的高度、不包含当前墙
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int sum = 0;
        leftMax[0] = 0;
        for(int i = 1 ;i < length-1;i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        rightMax[length -1] = 0;
        for(int i = length -2 ;i >= 0;i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        for(int i =1 ;i<length -1 ;i++) {
            int min = Math.min(leftMax[i],rightMax[i]);
            //只有两者的较小值比当前墙的高度大，才会接住雨水
            if(min > height[i]) {
                sum += (min-height[i]);
            }
        }
        return sum;
    }
}
