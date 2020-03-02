package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PostOrder
 * @Description 后续遍历二叉树
 * @Author JH
 * @Date 2019/11/21 10:35
 */
public class PostOrder {

    //后续遍历二叉树，定义两个栈
    public List<Integer>  postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valStack = new Stack<>();
        nodeStack.push(root);
        while(nodeStack.size() > 0) {
            TreeNode node = nodeStack.pop();
            valStack.push(node.val);
            if(node.left != null) {
                nodeStack.push(node.left);
            }
            if(node.right != null) {
                nodeStack.push(node.right);
            }
        }
        while(!valStack.isEmpty()) {
            res.add(valStack.pop());
        }
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    //递归方式
    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        res.add(root.val);
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
        PostOrder postOrder = new PostOrder();
        List<Integer> list = postOrder.postOrder(node1);
        System.out.println(list);
    }
}
