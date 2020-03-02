package offer;

/**
 * @Author JH
 * 输入两个链表，找到他们的第一个公共节点
 *
 **/
public class FindFirstCommonNode {
    // 不需要遍历链表的解法
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int count = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2 ) {
            if(p1.next!=null) {
                p1 = p1.next;
            }else {
                p1 = pHead2;
                if(count <2){
                    count++;
                }else {
                    return null;
                }
            }

            if(p2.next != null) {
                p2 = p2.next;
            }else {
                if(count <2){
                    count++;
                }else {
                    return null;
                }
            }

        }
        return p1;

    }

}
