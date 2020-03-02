package tree;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
//    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
//        int parentVal = root.val;
//        int pVal = p.val;
//        int qVal = q.val;
//        if(pVal > parentVal && qVal > parentVal) {
//            return lowestCommonAncestor(root.right,p,q);
//        } else if(pVal < parentVal && qVal < parentVal) {
//            return lowestCommonAncestor(root.left,p,q);
//        } else {
//            return root;
//        }
//    }

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null)
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        return null;

    }

}
