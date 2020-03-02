package hot100;

import java.util.Stack;

/**
 * @ClassName Flatten
 * @Description 二叉树展为链表
 * @Author JH
 * @Date 2019/9/11 15:12
 */
public class Flatten {
    //将跟节点的左子树放到原先右子树的位置，再将原先的右子树放在 原先左子树的最右子节点上
    public void flatten(TreeNode root) {
        while (root != null) {
            if(root.left == null) {
                root = root.right;
            } else {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }

    }

    public void flatten2(TreeNode node) {
        Stack<TreeNode> toVisit = new Stack<>();
        TreeNode cur = node;
        TreeNode pre = null;
        while(cur != null || !toVisit.isEmpty()) {
                while (cur != null) {
                    //添加跟节点
                    toVisit.push(cur);
                    //递归添加右节点
                    cur = cur.right;
                }
                //已经访问到最右的节点了
                cur = toVisit.peek();
                //不存在左节点或者左节点已经访问过的情况下，访问根节点
                if(cur.left == null || cur.left == pre) {
                    cur = toVisit.pop();
                    cur.right = pre;
                    cur.left = null;
                    pre = cur;
                    cur = null;
                }else {
                    //左节点还没有访问过就先访问左节点
                    cur = cur.left;
                }

        }
    }

}
