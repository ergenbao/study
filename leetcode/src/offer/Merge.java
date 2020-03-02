package offer;

/**
 * @Author JH
 * 输入两个单调递增的链表，输出两个链表合成后的链表，合成后的链表 满足单调不减原则
 **/
public class Merge {

    public static ListNode merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode newHead;
        if(list1.val>=list2.val) {
            newHead = new ListNode(list2.val);
            newHead.next = merge(list1,list2.next);
        }else {
            newHead = new ListNode(list1.val);
            newHead.next = merge(list1.next,list2);
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode5.next = listNode7;
        listNode3.next = listNode5;
        listNode1.next = listNode3;

        listNode6.next = listNode8;
        listNode4.next = listNode6;
        listNode2.next = listNode4;

        ListNode merge = merge(listNode1, listNode2);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }


    }

}
