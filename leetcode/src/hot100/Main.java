package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JH
 * */
public class Main {

    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>(16);
        //key : hot100 leetcode 题号
        //value : 类名
        //1.两数之和
        map.put(1,TwoSum.class);
        //2、两数相加
        map.put(2,AddTwoNumbers.class);
        //3、无重复字符的最长字串
        map.put(3,LengthOfLongestSubstring.class);
        //4、两个有序数组中位数
        map.put(4,FindMedianSortedArrays.class);
        //5、最长回文子串
        map.put(5,LongestPalindrome.class);
        //10、正则表达式匹配
        map.put(10,IsMatch.class);
        //11.盛最多水的容器
        map.put(11,MaxArea.class);
        //15.三数之和
        map.put(15,ThreeSum.class);
        //17、电话号码的字母组合
        map.put(17,LetterCombinations.class);
        //19、删除链表的倒数第n个节点
        map.put(19,RemoveNthFromEnd.class);
        //20、有效的括号
        map.put(20,IsValid.class);
        //21、合并两个有序链表
        map.put(21,MergeTwoLists.class);
        //22、括号生成
        map.put(22,GenerateParenthesis.class);
        //23、合并K个排序链表
        map.put(23,MergeKLists.class);
        //31、下一个排列
        map.put(31,NextPermutation.class);
        //32、最长有效括号
        map.put(32,LongestValidParentheses.class);
        //33、搜索旋转排序数组
        map.put(33,Search.class);
        //34、在排序数组中查找元素的第一个和最后一个位置
        map.put(34,SearchRange.class);
        //39、组合总数
        map.put(39,FindCombinationSum.class);
        //42、接雨水
        map.put(42,Trap.class);
        //46、全排列
        map.put(46,Permute.class);
        //48、旋转图像
        map.put(48,Rotate.class);
        //49、字母异位词分组
        map.put(49,GroupAnagrams.class);
        //53、最大子序和
        map.put(53,MaxSumArray.class);
        //55、跳跃游戏
        map.put(55,CanJump.class);
        //56、合并区间
         map.put(56,Merge.class);
        //62、不同路径
         map.put(62,UniquePaths.class);
        //64、最小路径和
         map.put(64,MinPathSum.class);
        //70、爬楼梯
        map.put(70,ClimbStairs.class);
        //72、编辑距离
        map.put(72,MinDistance.class);
        //75、颜色分类
        map.put(75,SortColors.class);
        //76、最小覆盖子串
        map.put(76,MinWindow.class);
        //78、子集
        map.put(78,SubSets.class);
        //79、单词搜索
        map.put(79,Exist.class);
        //84、柱状图中最大的矩形
        map.put(84,LargestRectangleArea.class);
        //85、最大矩形
        map.put(85,MaximalRectangle.class);
        //94、二叉树的中序遍历
        map.put(94,InorderTraversal.class);
        //96、不同的二叉搜索树
        map.put(96,NumsTrees.class);
        //98、验证二叉搜索树
        map.put(98,IsValidBST.class);
        //101、对称二叉树
        map.put(101,IsSymmetric.class);
        //102、二叉树的层序遍历
        map.put(102,LevelOrder.class);
        //104、二叉树的最大深度
        map.put(104,MaxDepth.class);
        //105、从前序与中序遍历序列构造二叉树
        map.put(105,BuildTree.class);
        //114、二叉树展开为链表
        map.put(114,Flatten.class);
        //121、买卖股票的最佳时机
        map.put(121,MaxProfit.class);
        //124、二叉树的最大路径和
        map.put(124,MaxSumPath.class);
        //128、最长连续序列
        map.put(128,LongestConsecutive.class);
        //139、单词拆分
        map.put(139,"WordBreak");
        //141、环形链表
        map.put(141,"HasCycle");
        //146、LRU缓存机制
        map.put(146,"LRUCache");
        //148、排序链表
        map.put(148,"SortList");
        //152、乘积最大子序列
        map.put(152,"MaxProduct");
        //155、最小栈
        map.put(155,"MinStack");
        //160、相交链表
        map.put(160,"GetIntersectionNode");
        //169、求众数
        map.put(169,"MajorityElement");
        //198、打家劫舍
        map.put(198,"Rob");
        //200、岛屿数量
        map.put(200,"NumIslands");
        //207、课程表
        map.put(207,"CanFinish");
        //208、实现Trie(前缀树)
        map.put(208,"TrieNode");
        //221、最大正方形
        map.put(221,"MaximalSquare");
        //234、回文链表
        map.put(234,"IsPalindrome");
        //236、二叉树的最近公共祖先
        map.put(236,"LowestCommonAncestor");
        //238、除自身以外数组的乘积
        map.put(238,"ProductExceptSelf");
        //239、滑动窗口最大值
        map.put(239,"MaxSlidingWindow");
        //240、搜索二维矩阵||
        map.put(240,"SearchMatrix");
        //279、完全平方数
        map.put(279,"NumSquares");
        //283、移动零
        map.put(283,"MoveZeros");
        //287、寻找重复数
        map.put(287,"FindDuplicate");
        //297、二叉树的序列化和反序列化
        map.put(297,"SerializeAndDeserialize");
        //300、最长上升子序列
        map.put(300,"LengthOfLIS");
        //301、删除无效的括号
        map.put(301,"RemoveInvalidParentheses");
        //309、最佳买卖股票时机含冷冻期
        map.put(309,"MaxProfit");
        //312、戳气球
        map.put(312,"MaxCoins");
        //322、零钱兑换
        map.put(322,"CoinChange");
        //337、打家劫舍3
        map.put(337,"Rob3");
        //347、前k个高频元素
        map.put(347,"TopKFrequent");
        //394、字符串解码
        map.put(394,"DecodeString");
        //406、根据身高重建队列
        map.put(406,"ReconstructQueue");
        //416、分隔等和子集
        map.put(416,"CanPartition");
        //437、路径总和Ⅲ
        map.put(437,"PathSum");
        //438、找到字符串中所有字母异位词
        map.put(438,"FindAnagrams");
        //494、目标和
        map.put(494,"FindTargetSumWays");
        //538、把二叉搜索树转换为累加器
        map.put(538,"ConvertBST");
        //543、二叉树直径
        map.put(543,"DiameterOfBinaryTree");
        //560、和为k的子数组
        map.put(560,"SubArraySum");
        //581、最短无序连续子数组
        map.put(581,"FindUnsortedSubArray");
        //617、合并二叉树
        map.put(617,"MergeTrees");
        //621、任务调度器
        map.put(621,"LeastInterval");
        //647、回文子串
        map.put(647,"CountSubStrings");
        //739、每日温度
        map.put(739,"DailyTemperatures");
        map.put(888,"aaaa");
 
    }
}
