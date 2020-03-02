package offer;

/**
 * @Author: JH
 * @Date: 2019/4/13 20:34
 * 输入一颗数，求该树的深度
 */
public class TreeDepth {

    public int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left > right ? left +1 : right + 1;
    }

}
