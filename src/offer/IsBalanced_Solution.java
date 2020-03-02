package offer;

/**
 * @Author: JH
 * @Date: 2019/4/13 20:53
 * 判断一棵树是否是平衡二叉树
 */
public class IsBalanced_Solution {

    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isBalance;

    }
    public int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left-right) > 1) {
            isBalance = false;
        }
        return left > right ? left +1 : right + 1;

    }

}
