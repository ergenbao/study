package offer;

/**
 * @Author JH
 * 复制复杂链表
 **/
public class Clone {

    public RandomListNode clone(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.val);
                cloneNode.next = node.next;
                node.next = cloneNode;
                node = cloneNode.next;

        }
        node = head;
        while (node != null) {
                RandomListNode cloneNode = node.next;
                if(node.random!=null){
                    cloneNode.random = node.random.next;
                }else {
                    cloneNode.random = null;
                }
                node = cloneNode.next;
         }
        node = head;
        RandomListNode cloneHead = node.next;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
            if(node !=null) {
                cloneNode.next = node.next;
            }else{
                cloneNode.next = null;
            }

        }
        return cloneHead;

    }

}
