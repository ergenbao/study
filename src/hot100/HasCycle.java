package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HasCycle
 * @Description 环形链表
 * @Author JH
 * @Date 2019/9/19 10:38
 */
public class HasCycle {
    public boolean hasCycle(ListNode node) {

        Set<ListNode> set = new HashSet<>();
        while (node != null) {
            if(set.contains(node)) {
                return true;
            } else {
                set.add(node);
                node = node.next;
            }
        }
        return false;
    }
    public boolean hasCycle2(ListNode node) {
        if(node == null || node.next == null) {
            return false;
        }
        ListNode fast = node.next;
        ListNode slow = node;
        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
