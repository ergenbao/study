package tree;


import java.util.LinkedList;


/**
 *
 * 二叉搜索树迭代器*/
public class BSTIterator {

    LinkedList<TreeNode> list = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        if(root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.addFirst(root);
                root = root.left;
            }else {
                root = stack.removeFirst();
                list.add(root);
                root = root.right;
            }
        }
    }

    public int next(){
        return list.removeFirst().val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

}
