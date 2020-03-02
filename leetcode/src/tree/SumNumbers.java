package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 求根到叶子节点数字之和
 * */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        //从根节点到当前节点，路径和
        Map<TreeNode,String> prefix = new HashMap<>();
        TreeNode pre = null;
        prefix.put(root,String.valueOf(root.val));
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.addFirst(root);
                if(pre != null) {
                    prefix.put(root,prefix.get(pre)+root.val);
                }
                if(root.left == null && root.right == null) {
                    sum += Integer.parseInt(prefix.get(root));
                }
                pre = root;
                root = root.left;
            }else {
                root = stack.removeFirst();
                pre = root;
                root = root.right;

            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.sumNumbers(node1));
    }
}
