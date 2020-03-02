package tree;

import java.util.Arrays;

/**
 * @ClassName BuildTree2
 * @Description 从中序和后序遍历序列构造二叉树
 * @Author JH
 * @Date 2019/12/11 18:22
 */
public class BuildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int rootVal = postorder.length-1;
        int index = 0;
        for(int i = 0;i< inorder.length;i++) {
            if(inorder[i] == rootVal) {
                index = i;
            }
        }
        root.left= buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(postorder,index,postorder.length-1));
        return root;
    }


}
