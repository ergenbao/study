package offer;

/**
 * @Author JH
 * 一层层打印二叉树，需要换行
 **/
public class PrintTree {

    private int depth(TreeNode pTreeRoot){
        if(pTreeRoot==null){
            return 0;
        }
        int l = depth(pTreeRoot.left);
        int r = depth(pTreeRoot.right);
        if(l > r){
            return l + 1;
        }else{
            return r + 1;
        }
    }

    private void levelOrder(TreeNode pTreeNode, int level) {
        if(pTreeNode == null || level < 1){
            return ;
        }
        if(level == 1){
            System.out.print(pTreeNode.val+ " ");
            return ;
        }
        //左子树
        levelOrder(pTreeNode.left, level-1);
        //右子树
        levelOrder(pTreeNode.right, level-1);
    }

    public void printFromTopToBottom(TreeNode pTreeRoot){
        if(pTreeRoot==null){
            return ;
        }
        int depth = depth(pTreeRoot);
        for (int i = 1; i <= depth; ++i) {
            levelOrder(pTreeRoot, i);
        }
    }


}
