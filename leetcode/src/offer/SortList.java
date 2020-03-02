package offer;

/**
 * @Author: JH
 * @Date: 2019/6/10 17:20
 */
public class SortList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val =x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode another;
        if (mid == null) {
            another = null;
        }else {
            another = mid.next;
            //变原链表为两个独立的链表，很巧妙
            mid.next = null;
        }
        return mergeSortedList(sortList(head),sortList(another));
    }
    private ListNode mergeSortedList(ListNode first,ListNode second) {
        if(first == null && second == null) {
            return null;
        }
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        //虚拟一个head的前缀节点，避免前缀额外的操作确认头结点。
        ListNode pre = new ListNode(0);
        ListNode curNode = pre;
        ListNode cur1 = first;
        ListNode cur2 = second;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                curNode.next = cur1;
                cur1 =cur1.next;
            }else {
                curNode.next = cur2;
                cur2 = cur2.next;
            }
            curNode = curNode.next;
        }

        //处理剩下的元素
        if(cur1 != null) {
            curNode.next = cur1;
        }
        if (cur2 != null) {
            curNode.next = cur2;        }
        return pre.next;
    }

    //获取链表的中间节点
    public ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
