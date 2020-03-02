package tree;

/**
 * @ClassName SortedArrayToBST
 * @Description 将有序数组转换为二叉搜索树
 * @Author JH
 * @Date 2019/12/11 19:35
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return build(nums,0,nums.length -1);

    }
    public TreeNode build(int[] nums,int l,int r) {
        if(l > r) {
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums,l,mid-1);
        node.right = build(nums,mid+1,r);
        return node;

    }
}
