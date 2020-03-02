package hot100;

/**
 * @ClassName DiameterOfBinaryTree
 * @Description 二叉树的直径
 * @Author JH
 * @Date 2019/11/19 16:42
 */
public class DiameterOfBinaryTree {
    //设置一个变量，用于记录最大直径
    private int max =0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        //max记录当前的最大直径
        max = Math.max(left + right,max);
        //返回当前树的高度
        return Math.max(left,right) + 1;
    }

    public static void main(String[] args) {
        TreeNode $4 = new TreeNode(4);
        TreeNode $5 = new TreeNode(5);
        TreeNode $1 = new TreeNode(1);
        TreeNode $2 = new TreeNode(2);
        TreeNode $3 = new TreeNode(3);
        $1.left = $2;
        $1.right =$3;
        $2.left = $4;
        $2.right = $5;
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        int a = d.diameterOfBinaryTree($1);
        System.out.println(a);
    }

}
