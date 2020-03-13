package tree;

import java.util.LinkedList;


//左叶子之和
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int res = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.removeLast();

            if(node.left != null) {
                queue.addFirst(node.left);
                if(node.left.left == null && node.left.right == null) {
                    res += node.left.val;
                }
            }
            if(node.right != null) {
                queue.addFirst(node.right);
            }

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
        SumOfLeftLeaves s = new SumOfLeftLeaves();
        int i = s.sumOfLeftLeaves(node1);
        System.out.println(i);
    }

}
