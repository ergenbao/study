package offer;

import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/4/2 20:39
 * 栈的压入，栈的弹出
 * 设计一个辅助栈，如果下一个弹出的数字是辅助栈的栈顶，则辅助栈弹出，否则辅助栈入栈，如果所有数字都已经入栈，辅助
 * 栈的栈顶还不是下一个弹出的数字，则该序列不可能是一个弹出序列
 */
public class IsPopOrder {




    public boolean isPopOrder(int[] pushArray,int[] popArray) {
        if(pushArray == null || popArray == null || pushArray.length != popArray.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i = 0 ; i < popArray.length ; i++) {
            if(stack.isEmpty()) {
                stack.push(pushArray[j++]);
            }
            while (stack.peek() != popArray[i] && j<popArray.length) {
                    stack.push(pushArray[j++]);
            }
            if(stack.peek() == popArray[i]) {
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }

}
