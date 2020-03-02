package hot100;


/**
 * @ClassName SortList
 * @Description 排序链表
 * @Author JH
 * @Date 2019/9/19 18:44
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null  || head.next == null) {
            return head;
        }
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if(left.val > right.val) {
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = (left == null ? right : left);
        return res.next;

    }
}
