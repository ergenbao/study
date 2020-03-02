package offer;

import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/3/30 11:42
 * 用两个栈来实现一个队列，完成队列的push和pop操作，队列中的元素为int类型
 */
public class Queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int val) {
        stack1.push(val);
    }

    public int pop(){
            if(isEmpty()) {
                throw  new RuntimeException("Queue is empty");
            }

        if(!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public boolean isEmpty(){
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public static void main(String[] args) {
        Queue queue  = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }


}
