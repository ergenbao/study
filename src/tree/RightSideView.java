package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 * */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            while(count >0) {
                root = queue.removeLast();
                if(root.left != null) {
                    queue.addFirst(root.left);
                }
                if(root.right != null) {
                    queue.addFirst(root.right);
                }
                count--;
            }
            res.add(root.val);
        }
        return res;
    }
}
