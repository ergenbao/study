package tree;

/**
 * @ClassName Flatten
 * @Description 二叉树展开为链表
 * @Author JH
 * @Date 2019/12/17 18:32
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null) {
            return ;
        }
        while(root != null) {
            if(root.left != null) {
                TreeNode node = root.left;
                while(node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
                node = node.right;
            } else {
                root = root.right;
            }
        }
    }
}
