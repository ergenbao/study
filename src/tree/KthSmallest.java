package tree;

import java.util.LinkedList;

/**
 * 二叉搜索树第k小的元素
 * */
public class KthSmallest {
    public int kthSmallest (TreeNode root,int k) {
        if(root == null) {
            return -1;
        }
        int count = 1;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.addFirst(root);
                root = root.left;
            } else {
                root = stack.removeFirst();
                if(count == k) {
                    return root.val;
                }
                count ++;
                root = root.right;
            }
        }
        return -1;
    }
}
