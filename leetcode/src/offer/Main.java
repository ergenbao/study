package offer;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Object> map = new HashMap<>(16);
        //数组中重复的数字
        map.put(3,FindRepeatNumber.class);
        //二维数组中的查找
        map.put(4,FindInDoubleArray.class);
        //替换空格
        map.put(5,ReplaceSpace.class);
        //反转链表
        map.put(6,ReverseList.class);
        //重建二叉树
        map.put(7,BuildTree.class);
        //用两个栈实现队列
        map.put(9,Queue.class);
        //斐波那契数列
        map.put(10,Fibonacci.class);
        //青蛙跳台阶问题
        map.put(10,JumpFloor.class);
        //旋转数组的最小数字
        map.put(11,MinNumInRotateArray.class);
        //矩阵中的路径
        map.put(12,Exist.class);
        //二进制中1的个数
        map.put(15,NumberOf1.class);
        //数值的整数次方
        map.put(16,Power.class);
        //打印从1到最大的n位数
        map.put(17,PrintNumbers.class);
        //正则表达式匹配
        map.put(19,IsMatch.class);
        //表示数值的字符串
        map.put(20,IsNum.class);
        //调整数组顺序使奇数位于偶数前面
        map.put(21,Exchange.class);
        //链表中倒数第k个节点
        map.put(22,FindKthFromTail.class);
        //反转链表
        map.put(24,ReverseList.class);
        //合并两个排序的链表
        map.put(25,MergeTwoLists.class);
        //树的子结构
        map.put(26,IsSubStructure.class);

    }
}
