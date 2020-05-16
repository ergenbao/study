package hot100;

/**
 *  盛最多水的容器
 * */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0,l=0,r=height.length-1;
        while(l < r) {
            int curArea = Math.min(height[l],height[r]) * (r-l);
            if(curArea > maxArea) {
                maxArea = curArea;
            }
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
