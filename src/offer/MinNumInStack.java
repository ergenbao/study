package offer;

import java.util.Stack;

/**
 * @Author JH
 * 定义栈的数据结构，并实现一个能得到栈最小元素的min函数
 **/
public class MinNumInStack {

    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    private Integer temp = null;

    public void push(int val) {
        dataStack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
            temp = val;
        }else {
            if(val < temp){
                minStack.push(val);
                temp = val;
            }else {
                minStack.push(temp);
            }
        }
    }

    public int pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public int  min() {
        return minStack.peek();
    }


}
