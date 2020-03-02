package tree;

import java.util.*;

/**
 * @ClassName LevelOrder
 * @Description 二叉树的层次遍历
 * @Author JH
 * @Date 2019/11/21 11:38
 */
public class LevelOrder {

    //层次遍历二叉树，定义一个队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode>  queue = new LinkedList<>();
        queue.addFirst(root);
        while( !queue.isEmpty()) {
            int count  = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count > 0) {
                TreeNode node = queue.removeLast();
                count --;
                list.add(node.val);
                if(node.left != null) {
                    queue.addFirst(node.left);
                }
                if(node.right != null) {
                    queue.addFirst(node.right);
                }
            }
           res.add(list);

        }
        return res;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node4.left = node8;
//        node6.left = node9;
//        LevelOrder levelOrder = new LevelOrder();
//        List<List<Integer>> list = levelOrder.levelOrder(node1);
//        System.out.println(list);
        Map<Object,Object> map = new HashMap<>();
        map.put(null,null);
        map.put(null,null);
        System.out.println(map.get(null));
        Set<Object> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set.size());
    }
}
