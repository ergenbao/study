package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PreOrder
 * @Description 前序遍历二叉树
 * @Author JH
 * @Date 2019/11/21 9:37
 */
public class PreOrder {


    /**
    * 前序遍历  定义一个栈
    *
    * @param root 根节点
    * @return java.util.List<tree.TreeNode>
    * @author JH
    * @date 2019/11/21 10:22
    */
    public List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || stack.size() >0) {
            if(root != null) {
                res.add(root);
                stack.push(root);
                root = root.left;
            } else {
               root = stack.pop();
               root = root.right;
            }
        }
        return res;

    }

    //递归方式
    private List<Integer> res = new ArrayList<>();
    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left);
        helper(root.right);

    }





    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node6.left = node9;
        PreOrder order = new PreOrder();
        List<TreeNode> res = order.preOrder(node1);
       res.forEach(n -> System.out.println(n.val));
    }
}
