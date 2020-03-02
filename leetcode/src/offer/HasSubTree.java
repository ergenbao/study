package offer;

/**
 * @Author JH
 * 输入两颗二叉树A、B，判断B是不是A的子结构 （空树不是任何树的子结构）
 **/
public class HasSubTree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root2 != null && root1 != null) {
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1,root2);
            }
            if (!result)
                return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left,node2.left) &&
                doesTree1HaveTree2(node1.right,node2.right);
    }


    public boolean hasSubTree(TreeNode node1,TreeNode node2) {
        if(node1 == null || node2 == null) {
            return false;
        }
        if(node1.val == node2.val) {
            return true;
        }else {
            return hasSubTree(node1.left,node2) || hasSubTree(node1.right,node2);
        }

    }

    public boolean hasTree1ContainTree2 (TreeNode node1 ,TreeNode node2) {
        if(node1 == null) {
            return false;
        }
        if(node2 == null) {
            return true;
        }
        if(node1.val != node2.val) {
            return false;
        }

        return hasTree1ContainTree2(node1.left,node2.left) && hasTree1ContainTree2(node1.right,node2.right);

    }

}
