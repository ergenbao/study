package tree;

/**
 * @ClassName MaxDepth
 * @Description 二叉树的最大深度
 * @Author JH
 * @Date 2019/12/9 18:43
 */
public class MaxDepth {
    public int maxDepth (TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
