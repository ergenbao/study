package hot100;

/**
 * @ClassName IsValidBST
 * @Description 验证二叉搜索树
 * @Author JH
 * @Date 2019/9/11 11:28
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    /**
     * @param node  节点
     * @param lower 下限
     * @param upper 上线
     * @return boolean
     * @author JH
     * @date 2019/9/11 11:35
     */
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val <= lower) {
            return false;
        }
        if(upper != null && node.val >= upper) {
            return false;
        }
        return helper(node.left,lower,node.val) && helper(node.right,node.val,upper);
    }
}
