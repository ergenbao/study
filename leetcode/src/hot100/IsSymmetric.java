package hot100;



/**
 * 对称二叉树  给定一个二叉树，检查它是否是镜像对称的。
 * */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
       return helper(root,root);
    }
    private boolean helper(TreeNode node1, TreeNode node2) {
            if(node1 == null && node2 == null) {
                return true;
            }
            if(node1 == null || node2 == null) {
                return false;
            }
            return node1.val == node2.val && helper(node1.left,node2.right) && helper(node1.right,node2.left);
    }
}
