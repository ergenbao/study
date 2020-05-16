package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
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
}
