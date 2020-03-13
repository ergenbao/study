package hot100;

/**
 * 两数之和
 * */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        //返回值
        ListNode head = new ListNode(0);
        ListNode node = head;
        //进位
        int n = 0;
        while(l1 != null && l2 != null) {
            //节点值
           int val  = (l1.val + l2.val + n) % 10;
           //更新进位
           n = (l1.val + l2.val + n) / 10;
           node.next = new ListNode(val);
           node = node.next;
           l1 = l1.next;
           l2 = l2.next;

        }
        //如果l1比较长
        while (l1 != null) {
            int val  = (l1.val  + n) % 10;
            n = (l1.val  + n) / 10;
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;

        }
        //如果l2比较长
        while (l2 != null) {
            int val  = (l2.val  + n) % 10;
            n = (l2.val  + n) / 10;
            node.next = new ListNode(val);
            node = node.next;
            l2 = l2.next;

        }
        //最后有进位，需要在创建一个节点
        if(n != 0) {
            node.next = new ListNode(n);
        }
        return head.next;
    }
}
