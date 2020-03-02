package offer;

import java.util.Arrays;

/**
 * @Author JH
 * 输入二叉树的前序和中序遍历的结果，请重建该二叉树 假设二叉树没有重复元素
 * 中序遍历中与前序的第一个节点相等的为根节点
 **/
public class ReConstructBinaryTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        int[] ints = Arrays.copyOfRange(pre, 1, 3);

    }


    public static TreeNode constructBinaryTree(int[] pre,int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        if(pre == null ||in == null) {
            return null;
        }
        if(pre.length == 0 || in.length == 0) {
            return null;
        }
        for(int i = 0 ;i < pre.length ;i++) {
            if(pre[0] == in[i]) {
                root.left = constructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                root.right = constructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }

        return root;
    }


}
