package offer;

import java.util.Stack;

/**
 * @Author JH
 *操作给定的二叉树，使其变为源二叉树的镜像
 *遍历树中所有节点，将节点的左右子树调换
 **/
public class Mirror {



    public static void main(String[] args) {

    }
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root !=null || stack != null) {
            while (root != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }

    }


}
