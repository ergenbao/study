package hot100;

import java.util.Stack;

/**
 * @ClassName LargestRectangleArea
 * @Description 柱状图中的最大矩形
 * @Author JH
 * @Date 2019/9/10 14:04
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0 ;
        Stack<Integer> stack = new Stack<>();
        int p = 0 ;
        while(p < heights.length) {
            if(stack.isEmpty()) {
                stack.push(p++);
            } else {
                int top = stack.peek();
                if(heights[p] >= heights[top]) {
                    stack.push(p++);
                } else {
                    //此时的栈顶相当于此时要求面积的下标
                    int leftIndex = stack.isEmpty() ? -1 : stack.peek();
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
