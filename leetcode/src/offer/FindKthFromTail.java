package offer;

/**
 * @Author JH
 *输入一个链表，输出该链表倒数第k个节点
 * 定义一个快指针，一个慢指针，先让快指针走k步，然后让快慢指针同时走，当快指针到达尾部时，慢指针所在位置，就是倒数第k个节点
 **/
public class FindKthFromTail {

//    public ListNode findKthToTail(ListNode head,int k) {
//        if (head == null || k <= 0) {
//            return null;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        while(k-- > 1) {
//            if (fast.next != null)
//                fast = fast.next;
//            else
//                return null;
//        }
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//    }

    public ListNode findKthFromTail(ListNode head , int k) {
        if(head == null || k < 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- >1) {
            if(fast.next != null) {
                fast = fast.next;
            }else {
                return null;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }




}
