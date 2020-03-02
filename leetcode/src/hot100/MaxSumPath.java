package hot100;



/**
 * @ClassName MaxSumPath
 * @Description 二叉树的最大路径和
 * @Author JH
 * @Date 2019/9/12 13:52
 */
public class MaxSumPath {
    int maxSum = Integer.MAX_VALUE;
    public int maxSumPath(TreeNode root) {
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //如果小于0就按0处理
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right),0);
        int new_path = root.val + left + right;
        maxSum = Math.max(maxSum,new_path);
        return root.val + Math.max(left,right);
    }
}
