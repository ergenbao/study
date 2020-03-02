package tree;

/**
 * @ClassName IsBalanced
 * @Description 平衡二叉树
 * @Author JH
 * @Date 2019/12/13 15:50
 */
public class IsBalanced {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        depth(root);
        return isBalanced;
    }
    public int depth(TreeNode root) {
        if(root == null ) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        if(Math.abs(l-r) > 1) {
            isBalanced = false;
        }
        return l > r ? l+1 : r+1;
    }
}
