package hot100;

import java.util.Stack;

/**
 * @ClassName LargestRectangleArea
 * @Description 柱状图中的最大矩形 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *  时间O(n) 空间O(n)
 * @Author JH
 * @Date 2019/9/10 14:04
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0 ;
        //stack用于存储角标
        Stack<Integer> stack = new Stack<>();
        //当前指针
        int p = 0 ;
        while(p < heights.length) {
            if(stack.isEmpty()) {
                stack.push(p++);
            } else {
                int top = stack.peek();
                //如果此时柱状图是递增的，这时无法确定以heights[p]为高的矩形面积
                if(heights[p] >= heights[top]) {
                    stack.push(p++);
                } else {
                    //左边第一个小于当前柱子的下标
                    int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                    //p:右边第一个小于当前柱子的下标
                    maxArea = Math.max(maxArea,(p-leftIndex-1) * heights[stack.pop()]);
                }

            }
        }
        while(!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int right = heights.length;
            maxArea = Math.max(maxArea,(right -leftIndex -1) * height);
        }


        return maxArea;
    }
}
