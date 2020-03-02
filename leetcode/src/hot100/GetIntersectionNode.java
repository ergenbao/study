package hot100;

/**
 * @ClassName GetIntersectionNode
 * @Description 相交链表
 * @Author JH
 * @Date 2019/9/21 10:45
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pa =headA,pb = headB;
        while (pa != pb) {
            pa = (pa == null ? headB :pa.next);
            pb = (pb == null ? headA : pb.next);
        }
        return pa;
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}
