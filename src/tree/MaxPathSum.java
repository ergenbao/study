package tree;

/**
 * @ClassName MaxPathSum
 * @Description 二叉树中的最大路径和
 * @Author JH
 * @Date 2020/1/3 15:08
 */
public class MaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        int newPath = root.val +left + right;
        maxSum = Math.max(maxSum,newPath);
        return root.val + Math.max(left,right);
    }
}
