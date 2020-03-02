package tree;

import java.util.Stack;

/**
 * @ClassName IsValidBST
 * @Description 验证二叉树
 * @Author JH
 * @Date 2019/11/25 18:07
 */
public class IsValidBST {
    //递归 要判断当前节点是否小于上限 大于下限
//    public boolean isValidBST(TreeNode root) {
//        return helper(root,null,null);
//    }
//    private boolean helper(TreeNode node ,Integer lower, Integer upper) {
//        if(node == null) {
//            return true;
//        }
//        int val  = node.val;
//        if(lower != null && val <= lower) {
//            return false;
//        }
//        if(upper != null && val >= upper) {
//            return false;
//        }
//        if(!helper(node.left,lower,val)) {
//            return false;
//        }
//        if(!helper(node.right,val,upper)) {
//            return false;
//        }
//        return true;
//    }

    //中序遍历二叉树，判断每个元素是否大于上一个元素，如果不满足，返回false
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        while(stack.size() > 0 || root != null) {
           if(root != null) {
               stack.push(root);
               root = root.left;
           } else {
               root = stack.pop();
               if(root.val <= last) {
                   return false;
               }
               last = root.val;
               root = root.right;
           }
        }
        return true;
    }


}
