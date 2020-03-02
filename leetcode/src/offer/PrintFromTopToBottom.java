package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: JH
 * @Date: 2019/4/2 21:31
 * 从上往下打印出二叉树的每个节点，从层次节点从左至右打印
 */
public class PrintFromTopToBottom {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.offer(1);
        list.offer(2);
        list.offer(3);
        list.offer(4);
        Integer poll = list.poll();
        Integer pop = list.pop();
        System.out.println(pop);
    }

    public static List<Integer> printFromTopToBottom (TreeNode root) {
        if (root == null){
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        result.add(root.val);
        if(root.left != null) {
            queue.offer(root.left);
        }
        if(root.right != null) {
            queue.offer(root.right);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            result.add(node.val);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;

    }

}
