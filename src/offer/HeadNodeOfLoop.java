package offer;

/**
 * @Author JH
 * 链表中包含一个环，找出这个环的起点
 **/
public class HeadNodeOfLoop {

    public ListNode findHeadOfLoop(ListNode phead) {
        ListNode fast = phead;
        ListNode slow = phead;
        while (fast != null && fast.next !=null) {
            fast = fast .next.next;
            slow = slow.next;
            if (fast != null && fast == slow) {
                fast = phead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
