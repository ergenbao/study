package offer;

/**
 * @Author JH
 * O(1)时间删除链表节点
 **/
public class DeleteNode {

//    public void deleteNode(ListNode head, ListNode deListNode) {
//        if (deListNode == null || head == null)
//            return;
//
//        if (head == deListNode) {
//            head = null;
//        } else {
//            // 若删除节点是末尾节点，往后移一个
//            if (deListNode.nextNode == null) {
//                ListNode pointListNode = head;
//                while (pointListNode.nextNode.nextNode != null) {
//                    pointListNode = pointListNode.nextNode;
//                }
//                pointListNode.nextNode = null;
//            } else {
//                deListNode.data = deListNode.nextNode.data;
//                deListNode.nextNode = deListNode.nextNode.nextNode;
//            }
//        }
//    }

    static class  ListNode{
        int val;
        ListNode next;
    }


    public ListNode deleteNode(ListNode head,int  val) {
        if(head == null ) {
            return head;
        }
        if (head.val == val) {
           return head.next;
        }
        ListNode cur = head;
        while(cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        //而如果是cur.next==null导致的跳出循环，则说明链表中查询完毕也没有找到对应节点，不对链表进行修改。
        if(cur.next != null) {
            cur.next = cur.next.next;
        }

        return head;
    }




}
