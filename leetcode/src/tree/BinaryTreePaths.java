package tree;


import java.util.*;

/**
 * 二叉树的所有路径
 * */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        //key 当前节点 value 从根节点到当前节点的路径
        Map<TreeNode,String> pathMap = new HashMap<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.addFirst(root);
                if(pathMap.get(prev) != null) {
                    pathMap.put(root,pathMap.get(prev) + root.val);
                } else {
                    pathMap.put(root,root.val+"");
                }
                if(root.left == null && root.right == null) {
                    res.add(pathMap.get(root));
                }
                prev = root;
                root = root.left;

            } else {
                root = stack.removeFirst();
                prev = root;
                root = root.right;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node6.left = node9;
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> list = binaryTreePaths.binaryTreePaths(node1);
        System.out.println(list);
    }

}
