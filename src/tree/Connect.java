package tree;

/**
 * @ClassName Connect
 * @Description 填充每个节点的下一个右侧节点指针
 * @Author JH
 * @Date 2019/12/17 19:00
 */
public class Connect {
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public Node connect2(Node root) {
        Node pre = root;
        while(pre != null ) {
            Node cur = pre;
            while(cur != null) {
                if(cur.left != null ) {
                    cur.left.next = cur.right;
                }
                if(cur.right != null && cur.next != null) {
                    cur.right.next =cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
