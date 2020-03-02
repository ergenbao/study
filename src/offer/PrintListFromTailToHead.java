package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/3/28 21:25
 * 输入一个链表，从尾到头打印链表每个节点的值
 */
public class PrintListFromTailToHead {


    static class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static List printListTailToHead(ListNode listNode) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        if(listNode == null)return list;
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return  list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next = node4;
        node4.next = node5;
        List list = printListTailToHead(node1);
        for (int i =0 ;i<list.size();i++) {
            System.out.println(list.get(i));
        }

    }

}
