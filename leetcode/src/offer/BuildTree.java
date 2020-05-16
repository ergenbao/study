package offer;



import java.util.Arrays;

/**
 * @ClassName BuildTree
 * @Description 从前序和中序遍历序列构造二叉树
 * @Author JH
 * @Date 2019/12/10 9:07
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[0]);
        //找到根节点在中序中的位置
        int index = 0;
        for(int i = 0;i< inorder.length;i++) {
            if(inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        node.left = buildTree(Arrays.copyOfRange(preorder,1,index +1),Arrays.copyOfRange(inorder,0,index));
        node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index + 1,inorder.length));
        return node;
    }
}
