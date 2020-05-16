package offer;

import java.util.ArrayList;

/**
 * @Author JH
 **/
public class FindPath {





    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    int sum = 0;
    public ArrayList<ArrayList<Integer>> getPath(TreeNode root,int target) {
        if(root == null){
            return null;
        }
        boolean isLeaf = root.left == null && root.right == null ;
        sum += root.val;
        list.add(root.val);
        if(isLeaf && sum == target) {
            ArrayList<Integer> path = new ArrayList<Integer>();
            for(int i = 0 ; i<list.size() ; i++) {
                path.add(list.get(i));
            }
            result.add(path);
        }
        if(sum < target && root.left != null){
            getPath(root.left,target);
        }

        if(sum < target && root.right != null) {
            getPath(root.right,target);
        }
        sum -=root.val;
        list.remove(list.size()-1);

        return result;
    }








}
