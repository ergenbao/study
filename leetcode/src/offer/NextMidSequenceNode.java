package offer;

/**
 * @Author JH
 * 给定二叉树的一个节点，返回中根序列的下一节点
 **/
public class NextMidSequenceNode {

    public TreeLinkNode getMidNextNode(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
        }
            return null;
    }


}
