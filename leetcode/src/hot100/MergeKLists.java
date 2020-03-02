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

}
