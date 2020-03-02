package offer;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/4/25 20:57
 * 前序打印二叉树
 */
public class PreTree {

    /**
     * 非递归
     * @param root 根节点
     * */
    public List<TreeNode> preTree(TreeNode root) {
        List<TreeNode> result =  new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
           TreeNode node =  stack.pop();
           if (node.right != null) {
               stack.push(node.right);
           }
           if (node.left != null) {
               stack.push(node.left);
           }
           result.add(node);
        }
        return result;

    }


    public List<TreeNode> pre(TreeNode node)  {
        List<TreeNode> result = new ArrayList<>();
        pre(node,result);
        return result;
    }

    public void pre(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        result.add(root);
        pre(root.left);
        pre(root.right);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root!=null || stack.size() > 0) {
            if (root != null) {
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            }else {
                root = stack.pop();
                root = root.right;
            }
        }

    }

    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }


    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (s1.size() > 0 ) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null ){
                s1.push(node.right);
            }
        }
        while (s2.size() > 0) {
            System.out.println(s2.pop().val);
        }

    }

    public void printTreeFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0 ) {
            int count = queue.size();
            while (count > 0) {
                root = queue.pop();
                System.out.print(root.val);
                count--;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            System.out.println();
        }
    }


}
