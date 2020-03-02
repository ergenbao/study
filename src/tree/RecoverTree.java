package tree;

import java.util.Stack;

/**
 * @ClassName RecoverTree
 * @Description 恢复二叉搜索树
 * @Author JH
 * @Date 2019/12/3 19:50
 */
public class RecoverTree {
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null) {
                if(first == null && pre.val > root.val) {
                    first = pre;
                }
                if(first != null && pre.val > root.val) {
                    second = root;
                }
            }
            pre = root;
            root = root.right;
        }
    }
}
