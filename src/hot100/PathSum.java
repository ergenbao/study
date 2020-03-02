package hot100;

import java.util.HashMap;

/**
 * @ClassName PathSum
 * @Description 路径综合Ⅲ
 * @Author JH
 * @Date 2019/11/14 18:46
 */
public class PathSum {
//    public int pathSum(TreeNode root ,int sum) {
//            if(root == null) {
//                return 0;
//            }
//            return helper(root,sum) + helper(root.left,sum) + helper(root.right,sum);
//    }
//    private int helper(TreeNode root ,int sum) {
//        if(root == null) {
//            return 0;
//        }
//       sum = sum - root.val;
//       return (sum == 0 ? 1 :0) + helper(root.left,sum) + helper(root.right,sum);
//    }

    public int pathSum(TreeNode root,int sum) {
        if(root == null) {
            return 0;
        }
        //key是前缀和 ，value是大小为key的前缀和出现次数

        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        return core(prefixSum,sum,root,0);

    }
    public int core(HashMap<Integer,Integer> prefixSum,int target,TreeNode node,int currSum) {
            if(node == null) {
                return 0;
            }
            currSum = currSum + node.val;
            //root节点到当前节点这条路上是否存在节点value加和为target的路径
            int res = prefixSum.getOrDefault(currSum - target,0);
            //更新前缀和的哈希表
            prefixSum.put(currSum,prefixSum.getOrDefault(currSum,0) + 1);
            int leftRes = core(prefixSum,target,node.left,currSum);
            int rightRes = core(prefixSum,target,node.right,currSum);
            prefixSum.put(currSum,prefixSum.get(currSum)-1);
            return res + leftRes + rightRes;
    }

}
