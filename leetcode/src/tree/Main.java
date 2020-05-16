package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Main
 * @Description 索引
 * @Author JH
 * @Date 2019/11/21 9:35
 */
public class Main {
    public static void main(String[] args) {
        Map<Object,String> map = new HashMap<>();
        map.put(PreOrder.class,"先序遍历二叉树");
        map.put(MidOrder.class,"中序遍历二叉树");
        map.put(PostOrder.class,"后序遍历二叉树");
        map.put(LevelOrder.class,"层次遍历二叉树");
        map.put(ZigZagOrder.class,"之字打印二叉树");
        map.put(GenerateTrees.class,"不同的二叉搜索树Ⅱ");
        map.put(NumTrees.class,"不同的二叉搜索树");
        map.put(IsValidBST.class,"验证二叉搜索树");
        map.put(RecoverTree.class,"恢复二叉搜索树");
        map.put(IsSymmetric.class,"对称二叉树");
        map.put(MaxDepth.class,"二叉树的最大深度");
        map.put(BuildTree.class,"从前序和中序遍历序列构造二叉树");
        map.put(BuildTree2.class,"从中序和后序遍历序列构造二叉树");
        map.put(SortedArrayToBST.class,"将有序数组转换为二叉搜索树");
        map.put(IsBalanced.class,"平衡二叉树");
        map.put(MinDepth.class,"二叉树的最小深度");
        map.put(HasPathSum.class,"路径总和");
        map.put(HasPathSum2.class,"路径总和");
        map.put(Flatten.class,"二叉树展开为链表");
        map.put(Connect.class,"填充每个节点的下一个右侧节点指针");
        map.put(Connect2.class,"填充每个节点的下一个右侧节点指针Ⅱ");
        map.put(MaxPathSum.class,"二叉树中的最大路径和");
        map.put(SumNumbers.class,"求根到叶子节点数字之和");
        map.put(BSTIterator.class,"二叉搜索树迭代器");
        map.put(RightSideView.class,"二叉树的右视图");
        map.put(CountNodes.class,"完全二叉树的节点个数");
        map.put(InvertTree.class,"翻转二叉树");
        map.put(KthSmallest.class,"二叉搜索树中第K小的元素");
        map.put(LowestCommonAncestor.class,"二叉搜索树的最近公共祖先");
        map.put(BinaryTreePaths.class,"二叉树的所有路径");
        map.put(SumOfLeftLeaves.class,"左叶子之和");

    }
}
