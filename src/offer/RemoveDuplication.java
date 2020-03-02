package offer;

/**
 * @Author JH
 * 在一个排序的链表中，存在重复的节点，删除重复的节点
 **/
public class RemoveDuplication {

        public static ListNode deleteDuplication(ListNode phead) {
            if (phead == null) {
                return null ;
            }
            //创建新的头节点
            ListNode first = new ListNode(-1);
            first.next = phead;
            ListNode p = phead;
            ListNode preNode = first;
            while (p != null) {
                int val = p.val;
                if (p.next != null) {
                    if (p.next.val == val) {
                        preNode.next = p.next;
                    }else {
                        preNode = preNode.next;
                    }
                }
                p = p.next;
            }
            return first.next;
        }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        ListNode head = deleteDuplication(node1);
        while (head !=null) {
            System.out.println(head.val);
           head = head.next;
        }

    }


}
