package tree;

import java.util.LinkedList;

/**
 * @ClassName Connect2
 * @Description 填充每个节点的下一个右侧节点指针Ⅱ
 * @Author JH
 * @Date 2019/12/18 18:40
 */
public class Connect2 {
    public Node connect2(Node root) {
        if(root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            Node prev = queue.getLast();
            while(count > 0) {
                Node cur = queue.removeLast();
                if(cur.left != null) {
                    queue.addFirst(cur.left);
                }
                if(cur.right != null) {
                    queue.addFirst(cur.right);
                }
                count --;
                if(count > 0) {
                    Node next = queue.getLast();
                    prev.next = next;
                    prev = prev.next;
                }
            }
        }
        return root;
    }
}
