package hot100;



/**
 * @ClassName MinStack
 * @Description 最小栈
 * @Author JH
 * @Date 2019/9/20 16:15
 */
public class MinStack {
    class LinkedNode{
        int val;
        LinkedNode next;
    }

    LinkedNode head = new LinkedNode();
    LinkedNode minHead = new  LinkedNode();

    public void push(int x) {
        LinkedNode node = new LinkedNode();
        node.val = x;
        node.next = head.next;
        head.next = node;
        LinkedNode minNode = minHead.next;
        LinkedNode curMinNode = new LinkedNode();
        curMinNode.val = x;
        if (minNode == null) {
            minHead.next = curMinNode;
        }else {
            if (x <= minNode.val) {
                curMinNode.next = minNode;
                minHead.next = curMinNode;

            }
        }

    }
    public void pop(){
        LinkedNode node = head.next;
        if(node != null) {
            head.next = node.next;
        }
        LinkedNode minNode =  minHead.next;
        if(minNode != null && node.val == minNode.val) {
           minHead.next = minNode.next;
        }
    }
    public int top() {
        if(head.next != null) {
            return head.next.val;
        }
        return -1;
    }
    public int getMin() {
        LinkedNode minNode =  minHead.next;
        if(minNode != null) {
            return minNode.val;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}
