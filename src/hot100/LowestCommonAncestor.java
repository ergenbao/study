package hot100;

import java.util.*;

/**
 * @ClassName LowestCommonAncestor
 * @Description 二叉树的最近公共祖先
 * @Author JH
 * @Date 2019/10/14 16:31
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root,null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                parent.put(node.left,node);
                stack.push(node.left);
            }
            if(node.right != null) {
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
