package hot100;


/**
 * @ClassName ConvertBST
 * @Description 把二叉树转换为累加树
 * @Author JH
 * @Date 2019/11/19 13:58
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        core(root,0);
        return root;
    }

    public int core(TreeNode root,int preSum) {
        if(root == null) {
            return 0;
        }
        int rightRes = core(root.right,preSum);
        int old = root.val;
        root.val = root.val+rightRes + preSum;
        int leftRes = core(root.left,root.val);
        //返回的是以root为根的子树的原始值的和
        return leftRes + old + rightRes;
    }

}
