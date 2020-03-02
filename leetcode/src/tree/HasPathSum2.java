package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HasPathSum2
 * @Description 路径总和
 * @Author JH
 * @Date 2019/12/16 14:51
 */
public class HasPathSum2 {
    public List<List<Integer>> pathSum(TreeNode root ,int sum ) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,sum,res,new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root , int sum ,List<List<Integer>> res ,ArrayList<Integer> tmp) {
        if(root == null ) {
            return;
        }
        tmp.add(root.val);
        if(root.left == null && root.right == null && sum -root.val == 0) {
            res.add(new ArrayList<>(tmp));
        }
        helper(root.left,sum - root.val,res,tmp);
        helper(root.right,sum - root.val,res,tmp);
        tmp.remove(tmp.size()-1);
    }
}

