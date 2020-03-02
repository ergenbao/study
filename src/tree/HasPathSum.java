package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName HasPathSum
 * @Description 路径总和
 * @Author JH
 * @Date 2019/12/13 16:53
 */
public class HasPathSum {

//    public boolean hasPathSum(TreeNode root , int sum) {
//        if(root == null) {
//            return false;
//        }
//        sum -= root.val;
//        if((root.left == null) && (root.right == null)) {
//            return sum == 0;
//        }
//        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
//    }




    public boolean hasPathSum(TreeNode root , int sum) {
        if(root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        //key 当前节点  value  从根节点到当前节点的路径和（不包含当前节点）
        Map<TreeNode,Integer> prefix = new HashMap<>();
        //当前节点父节点
        TreeNode prev = new TreeNode(0);
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                Integer val = prefix.getOrDefault(prev, 0) + prev.val;
                prefix.put(root,val);
                prev = root;
                root = root.left;
            } else  {
                root = stack.pop();
                if(root.left == null && root.right == null && prefix.get(root) + root.val == sum) {
                    return true;
                }
                prev = root;
                root = root.right;
            }
        }
        return false;
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
        HasPathSum hasPathSum = new HasPathSum();
        boolean b = hasPathSum.hasPathSum(node1, 8);
        System.out.println(b);

    }
}
