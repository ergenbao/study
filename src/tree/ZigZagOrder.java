package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ZigZagOrder
 * @Description 之字打印二叉树
 * @Author JH
 * @Date 2019/11/21 14:21
 */
public class ZigZagOrder {

    //同样是定义一个队列，只不过保存值时，判断层级，如果是奇数，用addLast 否则用addFirst
    public List<List<Integer>> zigZagOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int level = 1;
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int count = queue.size();
            while(count >0) {
                TreeNode node = queue.removeLast();
                count -- ;
                if((level & 1) == 0) {
                   list.addFirst(node.val);
                } else  {
                    list.addLast(node.val);
                }
                if(node.left != null) {
                    queue.addFirst(node.left);
                }
                if(node.right != null) {
                    queue.addFirst(node.right);
                }
            }
            level ++;
            res.add(list);
        }
        return res;
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
        ZigZagOrder order = new ZigZagOrder();
        List<List<Integer>> res = order.zigZagOrder(node1);
        System.out.println(res);
    }
}
