package offer;

import com.sun.org.apache.regexp.internal.RE;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: JH
 * @Date: 2019/4/25 21:07
 * 中序打印二叉树
 */
public class MidTree {

    public void midOrder(TreeNode root) {

        List<TreeNode> result = new ArrayList<>();
            if (root == null) {
                return;
            }
            TreeNode p = root;

        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }else {
                TreeNode  node = stack.pop();
                System.out.println(node.val);
                p = node.right;
            }
        }

    }

}
