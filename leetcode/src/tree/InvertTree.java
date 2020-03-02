package tree;

import java.util.LinkedList;

/**
 * 翻转二叉树
 * */
public class InvertTree {

//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) {
//            return null;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.removeLast();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if(current.left != null) {
                queue.addFirst(current.left);
            }
            if(current.right != null) {
                queue.addFirst(current.right);
            }
        }
        return root;
    }

}
