package graph;

import java.util.List;

/**
 * @Author JH
 * 无向图中的节点
 **/
public class Node {

    public int val;

    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
