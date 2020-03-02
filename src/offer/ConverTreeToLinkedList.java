package offer;

/**
 * @Author JH
 * 将二叉搜索树转换为双向列表
 **/
public class ConverTreeToLinkedList {

        TreeNode head = null;
        TreeNode tail = null;
        public TreeNode conver(TreeNode root) {
            visit(root);
            return head;
        }

        public void visit(TreeNode root) {
            if(root == null) {
                return;
            }
            visit(root.left);
            createList(root);
            visit(root.right);
        }
        public void createList(TreeNode cur) {
            cur.left = tail;
            if(tail != null) {
                tail.right = cur;
            }else {
                head = cur;
            }
            tail = cur;
        }

}
