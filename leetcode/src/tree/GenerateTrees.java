package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName GenerateTrees
 * @Description 不同的二叉搜索树Ⅱ
 * @Author JH
 * @Date 2019/11/25 10:15
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<TreeNode>();
        }
        return helper(1,n);
    }

    private List<TreeNode> helper(int start ,int end) {
        List<TreeNode> res = new LinkedList<>();
        if(start > end ) {
            //添加一个null，这样当左子树为null时，也可以进入下面的循环遍历
            res.add(null);
            return res;
        }
        for(int i = start ; i <= end ; i++) {
            //以i为根节点的左子树的所有可能
            List<TreeNode> subLeftTree = helper(start,i-1);
            //以i为根节点的右子树的所有可能
            List<TreeNode> subRightTree = helper(i+1,end);
            //上面如果没有res.add(null) 当left 为null时，进不去循环
            for(TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }

        return res;
    }
}
