package hot100;

import java.util.LinkedList;


/**
 * @ClassName SerializeAndDeserialize
 * @Description 二叉树的序列化和反序列化
 * @Author JH
 * @Date 2019/10/23 14:37
 */
public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeLast();
            if(node == null) {
                sb.append("#,");
            }else {
                sb.append(node.val).append(",");
                queue.addFirst(node.left);
                queue.addFirst(node.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if("".equals(data)) {
            return null;
        }
        String[] strings = data.split(",");
        if(strings.length == 1 && strings[0].equals("#")){
            return null;
        }
        //利用一个队列保存下一层的节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.parseInt(strings[0]));
        queue.addFirst(head);
        int index = 1;
        while(index < strings.length) {
            TreeNode node = queue.removeLast();
            if(node != null) {
                TreeNode left = strings[index].equals("#") ? null : new TreeNode(Integer.parseInt(strings[index]));
                index ++ ;
                node.left = left;
                TreeNode right = strings[index].equals("#") ? null : new TreeNode(Integer.parseInt(strings[index]));
                index ++ ;
                node.right = right;
                queue.addFirst(left);
                queue.addFirst(right);
            }
        }
        return head;
    }
}
