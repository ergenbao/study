package offer;

/**
 * @Author JH
 * 输入一个链表，反转链表后，输出链表的所有元素
 **/
public class ReverseList {


    public ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode temp = null;
        while (head != null) {
            ListNode p = head.next;
            head.next = temp;
            temp = head;
            head = p;


        }
        return temp;
    }

}

