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
        int data;
        ListNode nextNode;
    }


    public void deleteNode(ListNode head,ListNode toDeleteNode) {
        if(head == null || toDeleteNode == null) {
            return;
        }
        if (head == toDeleteNode) {
            head = null;
        }else {
            //如果这个节点是尾节点
            if(toDeleteNode.nextNode == null) {
                ListNode node = head;
                while (node.nextNode.nextNode !=null){
                    node = node.nextNode;
                }
                node.nextNode = null;
            }else {
                toDeleteNode.data = toDeleteNode.nextNode.data;
                toDeleteNode.nextNode = toDeleteNode.nextNode.nextNode;
            }

        }


    }




}
