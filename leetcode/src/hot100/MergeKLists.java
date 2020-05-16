package hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MergeKLists
 * @Description 合并K个排序链表
 * @Author JH
 * @Date 2019/9/3 11:38
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //一个小顶堆、默认按自然排序、可以自定义comparator
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }

    public ListNode fun2(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int k = lists.length;
        while(k >1) {
            int index = 0;
            for(int i = 0;i<k;i+=2) {
                if(i == k-1) {
                    lists[index++] = lists[i];
                }else {
                    lists[index++] = mergeTwoLists(lists[i],lists[i+1]);
                }
            }
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }

}
